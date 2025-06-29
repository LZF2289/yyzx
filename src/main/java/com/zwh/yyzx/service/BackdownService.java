package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.BackdownDTO;
import com.zwh.yyzx.pojo.Backdown;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.BackdownVo;

public interface BackdownService extends IService<Backdown> {

    ResultVo<Page<BackdownVo>> listBackdownVo(BackdownDTO backdownDTO) throws Exception;

    ResultVo examineBackdown(Backdown backdown) throws Exception;
}
