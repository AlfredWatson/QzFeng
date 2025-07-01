package com.yzunlp.qzfeng.service;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.dto.UserInfoDTO;
import com.yzunlp.qzfeng.domain.po.*;

public interface UserInfoService {

    int register(RegisterDTO registerDTO);

    void updateUserInfo(UserInfoDTO userInfoDTO);

    UserInfo login(LoginDTO loginDTO);

}
