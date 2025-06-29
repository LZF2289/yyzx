package com.zwh.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.pojo.Nurserecord;
import com.zwh.yyzx.vo.NurseRecordsVo;
import org.apache.ibatis.annotations.Param;

public interface NurserecordMapper extends BaseMapper<Nurserecord> {


    Page<NurseRecordsVo> selectNurseRecordsVo(@Param("page")Page<NurseRecordsVo> page,
                                              @Param("custormerId") Integer custormerId);
}
