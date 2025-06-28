package com.yzunlp.qzfeng.Service;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import com.yzunlp.qzfeng.domain.po.UserPropolis;

public interface UserService {
    void saveHealthStatus(UserHealth userHealth);

    void savePropolisUsage(UserPropolis userPropolis);

    UserInfo login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);
}
