package com.zwh.yyzx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.neuedu.com
 *
 * @version V1.0
 * @Title: null.java
 * @Package com.neuedu.yyzx.pojo
 * @Description: (用一句话描述该文件做什么)
 * @author: yyf
 * @private String: 2023/12/16 13:47
 * @Copyright: 2023 www.neuedu.com Inc. All rights reserved.
 * 注意：本内容仅限于沈阳东软科技集团培训传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OutRecordVo对象", description="")
public class OutwardVo implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注")
    private String	remarks;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer	isDeleted;

    @ApiModelProperty(value = "客户ID")
    private Integer	customerId;

    @ApiModelProperty(value = "外出事由")
    private String	outgoingreason;

    @ApiModelProperty(value = "外出时间")
    private Date outgoingtime;

    @ApiModelProperty(value = "预计回院时间")
    private Date expectedreturntime;

    @ApiModelProperty(value = "实际回院时间")
    private Date actualreturntime;

    @ApiModelProperty(value = "陪同人")
    private String	escorted;

    @ApiModelProperty(value = "与老人关系")
    private String	relation;

    @ApiModelProperty(value = "陪同人电话")
    private String	escortedtel;

    @ApiModelProperty(value = "审批状态 0-已提交 1-同意 2-拒绝")
    private Integer	auditstatus;

    @ApiModelProperty(value = "审批人")
    private String	auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date audittime;

    @ApiModelProperty(value = "护理人姓名")
    private String nickname;

    @ApiModelProperty(value = "护理人电话号码")
    private String phoneNumber;

    @ApiModelProperty(value = "护理项目编号")
    private String serialNumber;

    @ApiModelProperty(value = "护理项目名称")
    private String nursingName;

    @ApiModelProperty(value = "客户名称")
    private String customerName;
}
