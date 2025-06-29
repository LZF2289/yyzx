package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.pojo.Room;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CwsyBedVo;

public interface RoomService extends IService<Room> {

    public ResultVo<CwsyBedVo> findCwsyBedVo(String floor) throws Exception;
}