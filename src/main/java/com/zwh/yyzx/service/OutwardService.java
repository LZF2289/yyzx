package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.OutwardDTO;
import com.zwh.yyzx.pojo.Outward;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.OutwardVo;

public interface OutwardService extends IService<Outward> {

    ResultVo examineOutward(Outward outward) throws Exception;

    ResultVo<Page<OutwardVo>> queryOutwardVo(OutwardDTO outwardDT0) throws Exception;
}
