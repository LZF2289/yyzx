package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OutwardDTo-外出登记查询条件", description = "")
public class OutwardDTO {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
