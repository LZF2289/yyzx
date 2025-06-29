package com.zwh.yyzx.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.zwh.yyzx.pojo.Room;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wudagai
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CwsyBedVo对象", description="")
public class CwsyBedVo implements Serializable {
    @ApiModelProperty(value = "总床位")
    private Integer zcw;
    @ApiModelProperty(value = "空闲床位")
    private Integer kx;
    @ApiModelProperty(value = "有人床位")
    private Integer yr;
    @ApiModelProperty(value = "外出床位")
    private Integer wc;
    @ApiModelProperty(value = "房间和床位列表")
    private List<Room> roomList;
}
