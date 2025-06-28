package com.yzunlp.qzfeng.Service;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;

public interface UserService {
    void saveHealthStatus(UserHealth userHealth);

    void savePropolisUsage(UserPropolis userPropolis);

    UserInfo login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);

    void saveEvaluation(UserEval userEval);

    void saveCheckUp(UserCheckupForm userCheckupForm);
}
