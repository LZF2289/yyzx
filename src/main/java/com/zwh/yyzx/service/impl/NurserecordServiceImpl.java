package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.dto.NurseRecordDTO;
import com.zwh.yyzx.mapper.CustomernurseitemMapper;
import com.zwh.yyzx.mapper.NurserecordMapper;
import com.zwh.yyzx.pojo.Customernurseitem;
import com.zwh.yyzx.pojo.Nurserecord;
import com.zwh.yyzx.service.NurserecordService;
import com.zwh.yyzx.utils.ResultVo;
import com.zwh.yyzx.vo.NurseRecordsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class NurserecordServiceImpl extends ServiceImpl<NurserecordMapper, Nurserecord> implements NurserecordService {

    @Resource
    private CustomernurseitemMapper customernurseitemMapper;

    @Resource
    private NurserecordMapper nurserecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo addNurseRecord(Nurserecord nurserecord) throws Exception {

        nurserecord.setIsDeleted(0);//款认生效
        boolean temp = save(nurserecord);

        QueryWrapper qw = new QueryWrapper();
        qw.eq("custormer_id", nurserecord.getCustomerId());
        qw.eq("item_id", nurserecord.getItemId());
        qw.eq("is_deleted", 0);
        Customernurseitem customernurseitem = customernurseitemMapper.selectOne(qw);

        UpdateWrapper uw = new UpdateWrapper();
        uw.set("nurse_number", customernurseitem.getNurseNumber() - nurserecord.getNursingCount());


        uw.eq("custormer_id", nurserecord.getCustomerId());
        uw.eq("item_id", nurserecord.getItemId());
        uw.eq("is_deleted", 0);
        int row = customernurseitemMapper.update(null, uw);
        if (!(temp && row > 0)) {
            throw new Exception("护理记录生成失败");
        }
        return ResultVo.ok("护理记录生成成功");
    }

    @Override
    public ResultVo<Page<NurseRecordsVo>> queryNurseRecordsVo(NurseRecordDTO nurseRecordDTO) throws Exception {
        Page<NurseRecordsVo> page = new Page<>(nurseRecordDTO.getPageSize(), 6);
        nurserecordMapper.selectNurseRecordsVo(page, nurseRecordDTO.getCustomerId());
        return ResultVo.ok(page);
    }
}