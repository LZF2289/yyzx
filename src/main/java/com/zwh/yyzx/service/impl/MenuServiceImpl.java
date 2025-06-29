package com.zwh.yyzx.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.mapper.MenuMapper;
import com.zwh.yyzx.pojo.Menu;
import com.zwh.yyzx.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
