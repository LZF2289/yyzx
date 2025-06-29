package com.zwh.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.NurseItemDTO;
import com.zwh.yyzx.dto.UserDTO;
import com.zwh.yyzx.pojo.Nursecontent;
import com.zwh.yyzx.pojo.User;
import com.zwh.yyzx.service.UserService;
import com.zwh.yyzx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",required =true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",required =true)
    })
    @GetMapping("/login")
    public ResultVo<User> login(String username,String password) throws Exception {
        return userService.login(username,password);
    }

    @ApiOperation("查询系统用户-分页")
    @GetMapping("/findUserPage")
    public ResultVo<Page<User> > findUserPage(UserDTO userDTO) throws  Exception{
        Page<User> page=new Page<>(userDTO.getPageSize(),3);
        QueryWrapper qw=new QueryWrapper();
        if(userDTO.getNickname()!=null && userDTO.getNickname()!=""){
            qw.like("nickname","%"+userDTO.getNickname()+"%");
        }
        qw.eq("role_id",userDTO.getRoleId());
        qw.eq("is_deleted",0); //显示
        userService.page(page,qw);
        return ResultVo.ok(page);
    }

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllUserPage")
    public ResultVo<Page<User> > findAllUserPage(UserDTO userDTO) throws  Exception{
        Page<User> page=new Page<>(userDTO.getPageSize(),3);
        QueryWrapper qw=new QueryWrapper();
        userService.page(page,qw);
        return ResultVo.ok(page);
    }
    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public ResultVo addUser(User user) throws  Exception{
        user.setIsDeleted(0);
        userService.save(user);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("修改用户")
    @PostMapping("/updateUser")
    public ResultVo updateUser(User user) throws  Exception{
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.eq("id",user.getId());
        userService.update(user,updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @ApiOperation("删除用户")
    @GetMapping("/delUser")
    public ResultVo delUser(Integer id) throws  Exception{
        userService.removeById(id);
        return ResultVo.ok("删除成功");
    }
}