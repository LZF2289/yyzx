package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zwh.yyzx.dto.OutwardDTO;
import com.zwh.yyzx.pojo.Nurserecord;
import com.zwh.yyzx.pojo.Outward;
import com.zwh.yyzx.service.OutwardService;
import com.zwh.yyzx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/outward")
@CrossOrigin
@Api(tags = "外出管理")
public class OutwardController {
    @Resource
    private OutwardService outwardService;

    @ApiOperation("查询外出记录")
    @PostMapping("/queryOutwardVo")
    public ResultVo queryOutwardVo(OutwardDTO outwardDTO) throws  Exception{
        return outwardService.queryOutwardVo(outwardDTO);
    }

    @ApiOperation("添加外出审批")
    @PostMapping("/addOutward")
    public ResultVo addOutward(Outward outward) throws  Exception{
        outwardService.save(outward);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("审批外出申请")
    @PostMapping("/examineOutward")
    public ResultVo examineOutward(Outward outward) throws  Exception{
        return outwardService.examineOutward(outward);
    }

    @ApiOperation("撤回外出申请")
    @PostMapping("/delOutward")
    public ResultVo delOutward(Integer id) throws  Exception{
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<Outward>();
        updateWrapper.eq("id",id);
        updateWrapper.set("is_deleted",1);
        outwardService.update(updateWrapper);
        return ResultVo.ok("撤回成功");
    }

    @ApiOperation("登记回院时间")
    @PostMapping("/updateBackTime")
    public ResultVo updateBackTime(Outward outward) throws  Exception{
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<Outward>();
        updateWrapper.eq("id",outward.getId());
        updateWrapper.set("actualreturntime",outward.getActualreturntime());
        outwardService.update(updateWrapper);
        return ResultVo.ok("撤回成功");
    }
}