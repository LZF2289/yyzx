package com.zwh.yyzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwh.yyzx.pojo.Nursecontent;
import com.zwh.yyzx.utils.ResultVo;

import java.util.List;

public interface NursecontentService extends IService<Nursecontent> {

    ResultVo<List<Nursecontent>> listNurseItemByLevel(Integer LevelId) throws Exception;

    ResultVo updateNurseItem(Nursecontent nursecontent) throws Exception;

    ResultVo delNurseItem(Integer id) throws Exception;
}