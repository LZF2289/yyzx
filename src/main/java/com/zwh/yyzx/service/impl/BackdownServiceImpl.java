package com.zwh.yyzx.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.BackdownDTO;
import com.zwh.yyzx.mapper.BackdownMapper;
import com.zwh.yyzx.pojo.Backdown;
import com.zwh.yyzx.service.BackdownService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.BackdownVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {

    @Resource
    private BackdownMapper backdownMapper;

    @Override
    public ResultVo<Page<BackdownVo>> listBackdownVo(BackdownDTO backdownDTO) throws Exception {
        Page<BackdownVo> page = new Page<>(backdownDTO.getPageSize(), 6);
        backdownMapper.selectBackdownVo(page, backdownDTO.getUserId());
        return ResultVo.ok(page);
    }
    @Override
    public ResultVo examineBackdown(Backdown backdown)throws Exception {
        UpdateWrapper<Backdown> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", backdown.getId());
        updateWrapper.set("auditstatus", backdown.getAuditstatus());
        updateWrapper.set("audittine", backdown.getAudittime());
        updateWrapper.set("auditperson", backdown.getAuditperson());
        backdownMapper.update(backdown, updateWrapper);
        return ResultVo.ok("审批成功");
    }
}