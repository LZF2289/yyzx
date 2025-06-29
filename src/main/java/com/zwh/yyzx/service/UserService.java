package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.pojo.User;
import com.zwh.yyzx.utils.ResultVo;

public interface UserService extends IService<User> {

    public ResultVo<User> login(String username, String password) throws Exception;

}