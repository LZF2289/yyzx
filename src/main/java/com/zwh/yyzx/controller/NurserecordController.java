package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.NurseRecordDTO;
import com.zwh.yyzx.dto.OutwardDTO;
import com.zwh.yyzx.pojo.Nurserecord;
import com.zwh.yyzx.service.NurserecordService;
import com.zwh.yyzx.service.OutwardService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.NurseRecordsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurserecord")
@CrossOrigin
@Api(tags = "护理记录管理")
        public class NurserecordController {
    @Autowired
    private NurserecordService nurserecordService;
    @Autowired
    private OutwardService outwardservice;

    @ApiOperation("添加护理记录")
    @PostMapping("/addNurseRecord")
    public ResultVo addNurseRecord(Nurserecord nurserecord) throws Exception {
        return nurserecordService.addNurseRecord(nurserecord);
    }

    @GetMapping("/listNurseRecordsVo")
    @ApiOperation("容户护理记录信息动态查询（分页）")
    public ResultVo<Page<NurseRecordsVo>> listNurseRecordsvo(NurseRecordDTO nurseRecordDTO) throws Exception {
        return nurserecordService.queryNurseRecordsVo(nurseRecordDTO);
    }

    @GetMapping("/removeCustomerRecord")
    @ApiOperation("移除护理记录")
    public ResultVo removeCustomerRecord(Integer id) throws Exception {
        Nurserecord nurseRecord = new Nurserecord();
        nurseRecord.setIsDeleted(1);
        nurseRecord.setId(id);
        nurserecordService.updateById(nurseRecord);
        return ResultVo.ok("移除成功");
    }

    @ApiOperation("查询外出记录")
    @PostMapping("/queryOutwardVo")
    public ResultVo queryoutwardVo(OutwardDTO outwardDTO) throws Exception {
        return outwardservice.queryOutwardVo(outwardDTO);
    }
}