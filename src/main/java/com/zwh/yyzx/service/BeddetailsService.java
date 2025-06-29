package com.zwh.yyzx.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.BedDetailsDTO;
import com.zwh.yyzx.dto.ExchangeDTO;
import com.zwh.yyzx.pojo.Beddetails;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.BedDetailsVo;

public interface BeddetailsService extends IService<Beddetails> {

    ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) throws Exception;

    ResultVo exchangeBed(ExchangeDTO exchangeDTO) throws Exception;
}
