package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.BackdownDTO;
import com.zwh.yyzx.pojo.Backdown;
import com.zwh.yyzx.pojo.Bed;
import com.zwh.yyzx.pojo.Customer;
import com.zwh.yyzx.pojo.Outward;
import com.zwh.yyzx.service.BackdownService;
import com.zwh.yyzx.service.BedService;
import com.zwh.yyzx.service.BeddetailsService;
import com.zwh.yyzx.service.CustomerService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.BackdownVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/backdown")
@Api(tags = "退住管理")
@CrossOrigin
public class BackdownController {
    @Resource
    private BackdownService backdownService;
    @Resource
    private BedService bedService;
    @Resource
    private CustomerService customerService;
    //    private
    @PostMapping("/listBackdown")
    @ApiOperation("查询退住信息")
    public ResultVo listBackdown(BackdownDTO backdownDTO) throws Exception{
        return backdownService.listBackdownVo(backdownDTO);
    }
    @ApiOperation("添加退住审批")
    @PostMapping("/addBackdown")
    public ResultVo addBackdown(Backdown backdown) throws  Exception{
        backdownService.save(backdown);
        return ResultVo.ok("添加成功");
    }
    @PostMapping("/examineBackdown")
    @ApiOperation("审批退住")
    public ResultVo examineBackdown(Backdown backdown) throws Exception{
        Backdown bd = backdownService.getById(backdown.getId());
        //审批通过
        if(backdown.getAuditstatus() == 1){
            //修改床铺记录，对应床铺状态改为空闲
            Customer cs = customerService.getById(bd.getCustomerId());
            Bed bed = new Bed();
            bed.setId(cs.getBedId());
            bed.setBedStatus(1);
            bedService.updateById(bed);
        }
        return backdownService.examineBackdown(backdown);
    }
    @ApiOperation("撤回退住申请")
    @PostMapping("/delBackdown")
    public ResultVo delBackdown(Integer id) throws  Exception{
        UpdateWrapper<Backdown> updateWrapper = new UpdateWrapper<Backdown>();
        updateWrapper.eq("id",id);
        updateWrapper.set("is_deleted",1);
        backdownService.update(updateWrapper);
        return ResultVo.ok("撤回成功");
    }
}