package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CustomerPreferenceDTO客户喜好查询条件", description = "")
public class CustomerPreferenceDTO {
    @ApiModelProperty(value = "喜好编号")
    private Integer customerPreferenceId;
    @ApiModelProperty(value = "颜客姓名t")
    private String customerName;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;

}
