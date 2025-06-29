package com.zwh.yyzx.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.mapper.FoodMapper;
import com.zwh.yyzx.pojo.Food;
import com.zwh.yyzx.service.FoodService;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
}
