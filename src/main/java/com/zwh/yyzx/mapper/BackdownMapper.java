package com.zwh.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.pojo.Backdown;
import com.zwh.yyzx.vo.BackdownVo;
import org.apache.ibatis.annotations.Param;

public interface BackdownMapper extends BaseMapper<Backdown> {

    Page<BackdownVo> selectBackdownVo(@Param("page") Page<BackdownVo> page,
                                      @Param("userId") Integer userId);
}