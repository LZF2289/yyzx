package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.CustomerNurseItemDTO;
import com.zwh.yyzx.mapper.CustomerMapper;
import com.zwh.yyzx.mapper.CustomernurseitemMapper;
import com.zwh.yyzx.mapper.NursecontentMapper;
import com.zwh.yyzx.pojo.Customer;
import com.zwh.yyzx.pojo.Customernurseitem;
import com.zwh.yyzx.service.CustomernurseitemService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CustomerNurseItemVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomernurseitemServiceImpl extends ServiceImpl<CustomernurseitemMapper, Customernurseitem> implements CustomernurseitemService {
    @Resource
    private CustomernurseitemMapper customernurseitemMapper;
    @Resource
    private NursecontentMapper nursecontentMapper;
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public ResultVo addItemToCustomer(List<Customernurseitem> customernurseitems) throws Exception {
        if(customernurseitems.size()>0){
            //判断是选择级别添加级别中的护理项目,还是单独购买护理项目
            if(customernurseitems.get(0).getLevelId()!=null){ //级别附带项目
                //设置客户护理级别
                Customer customer=new Customer();
                customer.setId(customernurseitems.get(0).getCustormerId());
                customer.setLevelId(customernurseitems.get(0).getLevelId());
                int row1=customerMapper.updateById(customer);
                //批量给用户添加护理项目
                boolean temp=saveBatch(customernurseitems);
                if(!(row1>0&&temp)){
                    throw new Exception("护理项目配置失败");
                }
            }else{ //单独购买护理项目
                saveBatch(customernurseitems);
            }
            return ResultVo.ok("护理项目配置成功");
        }
        return ResultVo.fail("请选择需要添加的护理项目");
    }

    @Override
    public ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId) throws Exception{
        //更新客户级别为null
        UpdateWrapper uw1=new UpdateWrapper();
        uw1.set("level_id",null);
        uw1.eq("id",customerId);
        int row1=customerMapper.update(null,uw1);

        //删除客户当前级别的所有护理项目
        UpdateWrapper uw2=new UpdateWrapper();
        uw2.set("is_deleted",1);
        uw2.eq("level_id",levelId);
        uw2.eq("custormer_id",customerId);
//        Customernurseitem customernurseitem=new Customernurseitem();
//        customernurseitem.setIsDeleted(1);
        int row2=customernurseitemMapper.update(null,uw2);
        if(!(row1>0&&row2>0)){
            throw new Exception("护理项目配置失败");
        }
        return ResultVo.ok("移除成功");
    }

    @Override
    public ResultVo<Page<CustomerNurseItemVo>> listCustomerItem(CustomerNurseItemDTO customerNurseItemDTO) throws Exception {
        Page<CustomerNurseItemVo> page=new Page<>(customerNurseItemDTO.getPageSize(),6);
        customernurseitemMapper.selectCustomerItemVo(page,customerNurseItemDTO.getCustomerId());
        return ResultVo.ok(page);
    }
}