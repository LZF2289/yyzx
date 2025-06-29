package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.NurseRecordDTO;
import com.zwh.yyzx.pojo.Nurserecord;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.NurseRecordsVo;

public interface NurserecordService extends IService<Nurserecord> {

    ResultVo addNurseRecord(Nurserecord nurserecord) throws Exception;

    ResultVo<Page<NurseRecordsVo>> queryNurseRecordsVo(NurseRecordDTO nurseRecordDTO) throws Exception;
}