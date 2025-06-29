package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BackdownDTO退住查询条件", description = "")
public class BackdownDTO {

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}