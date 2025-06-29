package com.zwh.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.pojo.Customernurseitem;
import com.zwh.yyzx.vo.CustomerNurseItemVo;
import org.apache.ibatis.annotations.Param;

public interface CustomernurseitemMapper extends BaseMapper<Customernurseitem> {
    Page<CustomerNurseItemVo> selectCustomerItemVo(@Param("page") Page<CustomerNurseItemVo> page ,
                                                   @Param("custormerId") Integer custormerId) throws Exception;
}