package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.CustomerNurseItemDTO;
import com.zwh.yyzx.pojo.Customernurseitem;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CustomerNurseItemVo;

import java.util.List;

public interface CustomernurseitemService extends IService<Customernurseitem> {
    ResultVo addItemToCustomer(List<Customernurseitem> customernurseitems) throws Exception;

    ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId) throws Exception;

    ResultVo<Page<CustomerNurseItemVo>> listCustomerItem(CustomerNurseItemDTO customerNurseItemDTO) throws Exception;
}
