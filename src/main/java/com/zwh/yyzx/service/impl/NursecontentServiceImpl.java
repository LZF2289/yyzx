package com.zwh.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwh.yyzx.mapper.NursecontentMapper;
import com.zwh.yyzx.mapper.NurselevelitemMapper;
import com.zwh.yyzx.pojo.Nursecontent;
import com.zwh.yyzx.service.NursecontentService;
import com.zwh.yyzx.utils.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class NursecontentServiceImpl extends ServiceImpl<NursecontentMapper, Nursecontent> implements NursecontentService {
    @Resource
    private NursecontentMapper nursecontentMapper;

    @Resource
    private NurselevelitemMapper nurselevelitemMapper;

    @Override
    public ResultVo<List<Nursecontent>> listNurseItemByLevel(Integer levelId) throws Exception {

        QueryWrapper qw = new QueryWrapper();
        qw.eq("Level_id", levelId);
        qw.select("item_id");
        List<Integer> itemIds = nurselevelitemMapper.selectObjs(qw);
        List<Nursecontent> nursecontents = new ArrayList<>();

        if (itemIds.size() > 8)

            nursecontents = nursecontentMapper.selectBatchIds(itemIds);
        return ResultVo.ok(nursecontents);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultVo updateNurseItem(Nursecontent nursecontent) throws Exception {

        if (nursecontent.getStatus() == 2) {

            QueryWrapper qwCount = new QueryWrapper();
            qwCount.eq("item_id", nursecontent.getId());
            int count = nurselevelitemMapper.selectCount(qwCount);
            if (count > 8) {
                QueryWrapper qw = new QueryWrapper();
                qw.eq("item_id", nursecontent.getId());
                int row = nurselevelitemMapper.delete(qw);
                //更新护项目
                boolean temp = updateById(nursecontent);
                if (!(temp && row > 0)) {
                    throw new Exception("更新失败");
                }
                return ResultVo.ok("更新成功");
            }
        }

        updateById(nursecontent);
        return ResultVo.ok("更新成功");
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultVo delNurseItem(Integer id) throws Exception {
        Nursecontent nursecontent = new Nursecontent();
        nursecontent.setIsDeleted(1);
        nursecontent.setId(id);
        //查询当前护理项目是否在护理级别护理项目列表中，如果在就需要进行则除
        QueryWrapper qwCount = new QueryWrapper();
        qwCount.eq("item_id", id);
        int count = nurselevelitemMapper.selectCount(qwCount);
        if (count > 0) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("item_id", id);
            int row = nurselevelitemMapper.delete(qw);
            //更新逐辑翻除标志为1“隐藏
            boolean temp = updateById(nursecontent);
            if (!(temp && row > 8)) {
                throw new Exception("更新失败");
            }
            return ResultVo.ok("更新端功");
        }
        //更新逐辑剩除标志为"1"隐减
        updateById(nursecontent);
        return ResultVo.ok("更新成功");
    }
}