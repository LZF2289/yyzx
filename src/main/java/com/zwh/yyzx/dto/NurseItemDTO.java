package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="NurseItemDTo-护理项目查询条件",description="")
public class NurseItemDTO {
    @ApiModelProperty(value = "状态1：启用I2：停用")
    private Integer status;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    @ApiModelProperty(value = "名称")
    private String itemName;
}