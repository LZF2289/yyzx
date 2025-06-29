package com.zwh.yyzx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * All rights Reserved, Designed By www.neuedu.com
 *
 * @version V1.0
 * @Title: null.java
 * @Package com.neuedu.yyzx.vo
 * @Description: (用一句话描述该文件做什么)
 * @author: yyf
 * @date: 2023/12/27 0:46
 * @Copyright: 2023 www.neuedu.com Inc. All rights reserved.
 * 注意：本内容仅限于沈阳东软科技集团培训传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerPreferenceVo对象", description="")
public class CustomerPreferenceVo {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "顾客ID")
    private Integer customerId;

    @ApiModelProperty(value = "饮食喜好")
    private String preferences;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别")
    private Integer customerSex;

}
