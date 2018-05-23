package cn.com.zhirun.ssm0514.service;

import cn.com.zhirun.ssm0514.dao.CMemberModelMapper;
import cn.com.zhirun.ssm0514.dao.MemberModelMapper;
import cn.com.zhirun.ssm0514.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberModelMapper memberModelMapper;

    @Autowired
    CMemberModelMapper cMemberModelMapper;

    public MemberModel selectByPrimaryKey(String id) {

        return memberModelMapper.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(String id) {

        int num = memberModelMapper.deleteByPrimaryKey(id);
        return num;
    }

    public int insert(MemberModel record) {

        return memberModelMapper.insert(record);
    }

    public List<MemberModel> selectMembers(MemberModel member) {

        return cMemberModelMapper.selectMembers(member);
    }

    public List<MemberModel> selectByIds(String[] ids) {

        return cMemberModelMapper.selectByIds(ids);
    }
}
