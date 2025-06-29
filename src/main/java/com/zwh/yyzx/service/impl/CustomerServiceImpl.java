package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.KhxxDTO;
import com.zwh.yyzx.mapper.BedMapper;
import com.zwh.yyzx.mapper.BeddetailsMapper;
import com.zwh.yyzx.mapper.CustomerMapper;
import com.zwh.yyzx.pojo.Bed;
import com.zwh.yyzx.pojo.Beddetails;
import com.zwh.yyzx.pojo.Customer;
import com.zwh.yyzx.service.CustomerService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.KhxxCustomerVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Resource
    private BeddetailsMapper beddetailsMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private BedMapper bedMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addCustomer(Customer customer) throws Exception {
        //查询床位是否可用
        QueryWrapper qw=new QueryWrapper();
        Bed bed=bedMapper.selectById(customer.getBedId());
        if(bed.getBedStatus()!=1){
            return ResultVo.fail("该床位已有人");
        }

        customer.setIsDeleted(0);//新加客户默认生效
        customer.setUserId(-1);//新加客户默认无健康管家
        //生成客户信息
        int row1=customerMapper.insert(customer);
        //生成入住详情信息
        Beddetails beddetails=new Beddetails();
        beddetails.setBedId(customer.getBedId());
        beddetails.setStartDate(customer.getCheckinDate());
        beddetails.setEndDate(customer.getExpirationDate());
        beddetails.setBedDetails(customer.getBuildingNo()+"#"+bed.getBedNo());
        beddetails.setCustomerId(customer.getId());
        beddetails.setIsDeleted(0);//床位生效
        int row2=beddetailsMapper.insert(beddetails);
        //修改床位状态
        Bed bedUpdate=new Bed();
        bedUpdate.setId(customer.getBedId());
        bedUpdate.setBedStatus(2);
        int row3=bedMapper.updateById(bedUpdate);
        if(!(row1>0 && row2>0 && row3>0)){
            throw  new Exception("入住失败");
        }
        return ResultVo.ok("入住成功");
    }

    @Override
    public ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(KhxxDTO khxxDTO) throws Exception {
        Page<KhxxCustomerVo> page=new Page<>(khxxDTO.getPageSize(),6);//第一参数为当前页，第二个参数为页包含多少数据
        customerMapper.selectPageVo(page,khxxDTO.getCustomerName(),khxxDTO.getManType(),khxxDTO.getUserId());
        return ResultVo.ok(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo removeCustomer(Integer id,Integer bedId) throws Exception {
        //修改用户is_delete=1 不显示  成为历史老人
        Customer customer=new Customer();
        customer.setId(id);
        customer.setIsDeleted(1);
        int row1=customerMapper.updateById(customer);
        //修改床位为空闲 - 1
        Bed bed=new Bed();
        bed.setId(bedId);
        bed.setBedStatus(1);
        int row2=bedMapper.updateById(bed);

        //修改床位详细信息为 is_delete=1 不显示 （可能有多个床位信息 只修改is_delete为0的） 成为历史信息
        Beddetails beddetails=new Beddetails();
        beddetails.setIsDeleted(1);
        UpdateWrapper uw=new UpdateWrapper();
        uw.eq("customer_id",id);
        uw.eq("bed_id",bedId);
        uw.eq("is_deleted",0);
        int row3=beddetailsMapper.update(beddetails,uw);
        if(!(row1>0 && row2>0 && row3>0)){
            throw  new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo editCustomer(Customer customer) throws Exception {
        //①编辑客户信息
        int row1=customerMapper.updateById(customer);
        //②如果合同到期时间发生改变，更新用户当前生效的床位信息的退住时间为改变的合同日期
        if(customer.getExpirationDate()!=null){
            UpdateWrapper uw=new UpdateWrapper();
            uw.eq("customer_id",customer.getId());
            uw.eq("is_deleted",0);
            Beddetails beddetails=new Beddetails();
            beddetails.setEndDate(customer.getExpirationDate());
            int row2=beddetailsMapper.update(beddetails,uw);
            if(!(row1>0 && row2>0)){
                throw  new Exception("编辑失败");
            }
        }
        return ResultVo.ok("编辑成功");
    }
}
