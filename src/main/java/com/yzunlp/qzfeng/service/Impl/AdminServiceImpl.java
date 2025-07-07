package com.yzunlp.qzfeng.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yzunlp.qzfeng.common.PageResult;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import com.yzunlp.qzfeng.domain.vo.UserInfoBaseVO;
import com.yzunlp.qzfeng.domain.vo.UserInfoHealthVO;
import com.yzunlp.qzfeng.domain.vo.userQuestionnaireVO;
import com.yzunlp.qzfeng.mapper.AdminMapper;
import com.yzunlp.qzfeng.mapper.UserInfoMapper;
import com.yzunlp.qzfeng.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/7/4 15:31
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;


    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper){
        this.adminMapper  = adminMapper;
    }


    @Override
    public UserInfoHealthVO selectUserInfoHealthById(Long id) {
        return adminMapper.selectUserInfoHealthById(id);

    }

    @Override
    public userQuestionnaireVO selectUserQuestionnaireById(Long id) {
        userQuestionnaireVO vo = new userQuestionnaireVO();
        vo.setUserPropolisList(adminMapper.selectUserPropolisByUserId(id));
        vo.setUserEvalListerEval(adminMapper.selectUserEvalByUserId(id));
        vo.setUserCheckupFormList(adminMapper.selectUserCheckupFormByUserId(id));
        return vo;
    }

    @Override
    public PageResult getAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfoBaseVO> list = adminMapper.selectAllUsers();
        Page<UserInfoBaseVO> page = (Page<UserInfoBaseVO>) list;
        long total = page.getTotal();
        List<UserInfoBaseVO> result = page.getResult();
        return new PageResult(total,result);
    }
}
