package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.KhxxDTO;
import com.zwh.yyzx.pojo.Customer;
import com.zwh.yyzx.service.CustomerService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.KhxxCustomerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyh
 * @since 2023-11-07
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin
@Api(tags = "客户管理")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @ApiOperation("入住登记")
    @PostMapping("/rzdj")
    public ResultVo addCustomer(Customer customer) throws  Exception{
        return customerService.addCustomer(customer);
    }

    @GetMapping("/listKhxxPage")
    @ApiOperation("客户信息动态查询（分页）")
    public ResultVo<Page<KhxxCustomerVo>> listKhxxPage(KhxxDTO khxxDTO) throws Exception{
        return customerService.khxxFindCustomer(khxxDTO);
    }


    @GetMapping("/remove")
    @ApiOperation("根据key删除")
    public ResultVo remove(Integer id,Integer bedId) throws Exception{
        return customerService.removeCustomer(id,bedId);
    }

    @PostMapping("/editKhxx")
    @ApiOperation("编辑客户信息")
    public ResultVo editKhxx(Customer customer) throws Exception{
        return customerService.editCustomer(customer);
    }


}