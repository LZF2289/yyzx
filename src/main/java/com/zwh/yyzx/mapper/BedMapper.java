package com.zwh.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwh.yyzx.pojo.Bed;
import com.zwh.yyzx.vo.CwsyBedVo;

public interface BedMapper extends BaseMapper<Bed> {
    CwsyBedVo selectBedCount();
}