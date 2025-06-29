package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.CustomerPreferenceDTO;
import com.zwh.yyzx.pojo.Customerpreference;
import com.zwh.yyzx.service.CustomerpreferenceService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CustomerPreferenceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customerpreference")
@CrossOrigin
@Api(tags = "客户喜好管理")
public class CustomerpreferenceController {
    @Resource
    private CustomerpreferenceService customerpreferenceService;

    @PostMapping("/addCustomerperference")
    @ApiOperation("为顾客单个添加喜好")
    public ResultVo addcustomerperference(Customerpreference customerperference) throws Exception {
        customerpreferenceService.save(customerperference);
        return ResultVo.ok("添加顾客喜好");
    }

    @ApiOperation("更新顾客喜好")
    @PostMapping("/updateCustomerpreference")
    public ResultVo updateCustomerpreference(Customerpreference customerpreference) throws Exception {
        customerpreferenceService.updateById(customerpreference);
        return ResultVo.ok("更新颐客喜好");
    }

    @GetMapping("/listCustonerpreferencePage")
    @ApiOperation("顾客喜好查询（分页）/可以根据顾客姓名查询")
    public ResultVo<Page<CustomerPreferenceVo>> ListCustomerpreferencePage(CustomerPreferenceDTO customerPreferenceDTO) throws Exception {
        return customerpreferenceService.listCustomerPreferenceVoPage(customerPreferenceDTO);
    }
}