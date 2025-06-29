package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.KhxxDTO;
import com.zwh.yyzx.pojo.Customer;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.KhxxCustomerVo;

public interface CustomerService extends IService<Customer> {


    ResultVo addCustomer(Customer customer) throws Exception;

    ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(KhxxDTO khxxDTO) throws Exception;

    ResultVo removeCustomer(Integer id, Integer bediId) throws Exception;

    ResultVo editCustomer(Customer customer) throws Exception;
}