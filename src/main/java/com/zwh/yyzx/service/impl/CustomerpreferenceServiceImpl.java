package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.CustomerPreferenceDTO;
import com.zwh.yyzx.mapper.CustomerpreferenceMapper;
import com.zwh.yyzx.pojo.Customerpreference;
import com.zwh.yyzx.service.CustomerpreferenceService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CustomerPreferenceVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerpreferenceServiceImpl extends ServiceImpl<CustomerpreferenceMapper, Customerpreference> implements CustomerpreferenceService {
    @Resource
    private CustomerpreferenceMapper customerpreferenceMapper;

    @Override
    public ResultVo<Page<CustomerPreferenceVo>> listCustomerPreferenceVoPage(CustomerPreferenceDTO customerPreferenceDTO) throws Exception {
        Page<CustomerPreferenceVo> page = new Page<>(customerPreferenceDTO.getPageSize(), 6);
        customerpreferenceMapper.selectCustomerPreferenceVo(page, customerPreferenceDTO.getCustomerName());
        return ResultVo.ok(page);
    }
}
