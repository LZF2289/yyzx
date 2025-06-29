package com.zwh.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Food对象", description = "食品实体类")
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "食品名称")
    private String foodName;

    @ApiModelProperty(value = "食品类型")
    private String foodType;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "是否清真（0：否，1：是）")
    private Integer isHalal;

    @ApiModelProperty(value = "图片路径")
    private String foodImg;
}
