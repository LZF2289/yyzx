package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.MealDTO;
import com.zwh.yyzx.mapper.MealMapper;
import com.zwh.yyzx.pojo.Meal;
import com.zwh.yyzx.service.MealService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.MealVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

    @Resource
    private MealMapper mealMapper;

    @Override
    public ResultVo<Page<MealVo>> listMealVoPage(MealDTO mealDTO)throws Exception{
        Page<MealVo> page=new Page<>(mealDTO.getPageSize(),  5);
        mealMapper.selectMealVo(page,mealDTO.getWeekDay(),mealDTO.getMealType());
        return ResultVo.ok(page);
    }
}