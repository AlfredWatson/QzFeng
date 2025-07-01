package com.yzunlp.qzfeng.service;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;

public interface UserInfoService {

    int register(RegisterDTO registerDTO);

    UserInfo login(LoginDTO loginDTO);

    void saveHealthStatus(UserHealth userHealth);

    void savePropolisUsage(UserPropolis userPropolis);

    void saveEvaluation(UserEval userEval);

    void saveCheckUpForm(UserCheckupForm userCheckupForm);
}
