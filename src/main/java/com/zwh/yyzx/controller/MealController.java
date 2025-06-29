package com.zwh.yyzx.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwh.yyzx.dto.MealDTO;
import com.zwh.yyzx.pojo.Food;
import com.zwh.yyzx.pojo.Meal;
import com.zwh.yyzx.service.FoodService;
import com.zwh.yyzx.service.MealService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.MealVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/meal")
@CrossOrigin
@Api(tags="膳食日历管理")

public class MealController{
@Resource
private MealService mealService;
@PostMapping("/addMeal")
@ApiOperation("添加膳食")

        public ResultVo addMeal(Meal meal) throws Exception {
    mealService.save(meal);
    return ResultVo.ok("添加膳食");
};

    @ApiOperation("更新膳食")
            @PostMapping("/updateMeal")
            public ResultVo updateMeal(Meal meal) throws Exception {
        mealService.updateById(meal);
        return ResultVo.ok("更新要食");
    }
        @ApiOperation("剧除膳食")
                @GetMapping("/removeMeal")
                public ResultVo removeMeal(Integer id) throws Exception {
            mealService.removeById(id);
            return ResultVo.ok("删除膳食");
        }
            @PostMapping("/ListMeaLPage")
            @ApiOperation("膳食查询（分页）/可以根据星期查询，根据膳食类型（早餐/午餐/晚餐）")
                    public ResultVo<Page<MealVo>> listMealPage(MealDTO mealDTO) throws Exception {
                        return mealService.listMealVoPage(mealDTO);
                    }
}