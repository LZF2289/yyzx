package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.OutwardDTO;
import com.zwh.yyzx.mapper.OutwardMapper;
import com.zwh.yyzx.pojo.Outward;
import com.zwh.yyzx.service.OutwardService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.OutwardVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements OutwardService {

    @Resource
    private OutwardMapper outwardMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo examineOutward(Outward outward) throws Exception {
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", outward.getId());
        updateWrapper.set("auditstatus", outward.getAuditstatus());
        outwardMapper.update(outward, updateWrapper);
        return ResultVo.ok("审批成功");
    }

    @Override
    public ResultVo<Page<OutwardVo>> queryOutwardVo(OutwardDTO outwardDTO) throws Exception {
        Page<OutwardVo> page = new Page<>(outwardDTO.getPageSize(), 6);
        outwardMapper.selectOutwardVo(page, outwardDTO.getUserId());
        return ResultVo.ok(page);
    }
}