package com.yzunlp.qzfeng.mapper;

import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveHealthStatus(UserHealth userHealth);

    void savePropolisUsage(UserPropolis userPropolis);

    UserInfo login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);

    void save2info2health(Long healthId, Long infoId);
}
