package com.yzunlp.qzfeng.mapper;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int addUser(RegisterDTO registerDTO);

    // 根据手机号查询用户信息
    UserInfo selectByPhone(String phone);

    UserInfo selectByPhoneAndPassword(LoginDTO loginDTO);

    void saveHealthStatus(UserHealth userHealth);

    void savePropolisUsage(UserPropolis userPropolis);


    void save2info2health(Long healthId, Long infoId);

    void saveEvaluation(UserEval userEval);

    void saveCheckUp(UserCheckupForm userCheckupForm);
}
