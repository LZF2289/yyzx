package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.dto.MealDTO;
import com.zwh.yyzx.pojo.Meal;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.MealVo;

public interface MealService extends IService<Meal> {
    ResultVo<Page<MealVo>> listMealVoPage(MealDTO mealDTO) throws Exception;
}
