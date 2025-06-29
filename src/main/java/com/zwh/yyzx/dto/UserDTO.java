package com.zwh.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserDTO用户查询条件",description = "UserDTO")
public class UserDTO {
    @ApiModelProperty(value="系统角色1.管理员2.健康管家")
    private Integer roleId;
    @ApiModelProperty(value="页码")
    private Integer pageSize;
    @ApiModelProperty(value="用户真实姓名")
    private String nickname;
}
