package com.zwh.yyzx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.neuedu.com
 *
 * @version V1.0
 * @Title: null.java
 * @Package com.neuedu.yyzx.vo
 * @Description: (用一句话描述该文件做什么)
 * @author: yyf
 * @date: 2023/12/17 1:02
 * @Copyright: 2023 www.neuedu.com Inc. All rights reserved.
 * 注意：本内容仅限于沈阳东软科技集团培训传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BackdownVo对象", description="")
public class BackdownVo {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注")
    private String	remarks;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer	isDeleted;

    @ApiModelProperty(value = "客户ID")
    private Integer	customerId;

    @ApiModelProperty(value = "退住时间")
    private Date retreattime;

    @ApiModelProperty(value = "退住类型 0-正常退住  1-死亡退住 2-保留床位")
    private Integer	retreattype;

    @ApiModelProperty(value = "退住原因")
    private String	retreatreason;

    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer	auditstatus;

    @ApiModelProperty(value = "审批人")
    private String	auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date	audittime;

    @ApiModelProperty(value = "床位")
    private String	bed_details;

    @ApiModelProperty(value = "入住时间")
    private Date	checkinDate;

    @ApiModelProperty(value = "床位")
    private Integer	bedId;
    @ApiModelProperty(value = "客户名称")
    private String customerName;
}
