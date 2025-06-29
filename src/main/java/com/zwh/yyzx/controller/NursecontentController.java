package com.zwh.yyzx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.NurseItemDTO;
import com.zwh.yyzx.pojo.Nursecontent;
import com.zwh.yyzx.service.NursecontentService;
import com.zwh.yyzx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nursecontent")
@CrossOrigin
@Api(tags = "护理项目管理")
        public class NursecontentController {
    @Autowired
    private NursecontentService nursecontentService;

    @ApiOperation("添加护理项目")
    @PostMapping("/addNurseItem")
    public ResultVo addNurseIten(Nursecontent nursecontent) throws Exception {
        nursecontent.setIsDeleted(0);
        nursecontentService.save(nursecontent);
        return ResultVo.ok("添加成功");
    }
    @ApiOperation("查询护理项目分页")
    @GetMapping("/findNurseItemPage")
    public ResultVo<Page<Nursecontent>> findNurseItemPage(NurseItemDTO nurseItemDTO) throws Exception{
        Page<Nursecontent> page=new Page<>(nurseItemDTO.getPageSize(),6);
        QueryWrapper qw=new QueryWrapper();
        if(nurseItemDTO.getItemName()!=null &&nurseItemDTO.getItemName()!=""){
            qw.like( "nursing_name", "%"+nurseItemDTO.getItemName()+"%");
        }
        qw.eq( "status",nurseItemDTO.getStatus());
        qw.eq( "is_deleted",0); //显示
        nursecontentService.page(page,qw);
        return ResultVo.ok(page);
    }
        @ApiOperation("修改护理项目")
        @PostMapping("/updateNurSeItem")
        public ResultVo updateNurseItem(Nursecontent nursecontent) throws
        Exception {
            return nursecontentService.updateNurseItem(nursecontent);
        }
            @ApiOperation("删除护理项目")
            @GetMapping("/delNurseItem")
            public ResultVo delNurseItem(Integer id) throws Exception{
            return nursecontentService.delNurseItem(id);
        }
}

