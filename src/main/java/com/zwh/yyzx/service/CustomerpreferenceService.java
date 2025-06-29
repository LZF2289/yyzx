package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.CustomerPreferenceDTO;
import com.zwh.yyzx.pojo.Customerpreference;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CustomerPreferenceVo;

public interface CustomerpreferenceService extends IService<Customerpreference> {
    ResultVo<Page<CustomerPreferenceVo>> listCustomerPreferenceVoPage(CustomerPreferenceDTO customerPreferenceDTO)throws Exception;
}
