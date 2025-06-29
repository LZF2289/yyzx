package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.mapper.BedMapper;
import com.zwh.yyzx.mapper.RoomMapper;
import com.zwh.yyzx.pojo.Room;
import com.zwh.yyzx.service.RoomService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.CwsyBedVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Resource
    private BedMapper bedMapper;

    @Resource
    private RoomMapper roomMapper;

    @Override
    public ResultVo<CwsyBedVo> findCwsyBedVo(String floor) throws Exception {

        CwsyBedVo cwsyBedVo = bedMapper.selectBedCount();
        QueryWrapper qwRoomList = new QueryWrapper();
        qwRoomList.eq("room_floor", floor);
        List<Room> rooms = list(qwRoomList);
        for (Room room : rooms) {

            QueryWrapper qwBedList = new QueryWrapper();
            qwBedList.eq("room_no", room.getRoomNo());
            room.setBedList(bedMapper.selectList(qwBedList));
        }
        cwsyBedVo.setRoomList(rooms);
        return ResultVo.ok(cwsyBedVo);
    }
}