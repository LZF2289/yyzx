package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "KhxxDTO对象-客户信息查询条件", description = "")
public class KhxxDTO {
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    @ApiModelProperty(value = "老人类型1-自理老人2-护理老人3-无管家")
    private Integer manType;
    @ApiModelProperty(value = "系统健康管家（护工）")
    private Integer userId;
}