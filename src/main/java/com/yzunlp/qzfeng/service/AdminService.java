package com.yzunlp.qzfeng.service;

import com.github.pagehelper.Page;
import com.yzunlp.qzfeng.common.PageResult;
import com.yzunlp.qzfeng.domain.vo.UserInfoBaseVO;
import com.yzunlp.qzfeng.domain.vo.UserInfoHealthVO;
import com.yzunlp.qzfeng.domain.vo.userQuestionnaireVO;

import java.util.List;

public interface AdminService {
    UserInfoHealthVO selectUserInfoHealthById(Long id);

    userQuestionnaireVO selectUserQuestionnaireById(Long id);

    PageResult getAllUsers(int pageNum, int pageSize);
}
