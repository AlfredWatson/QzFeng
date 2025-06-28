package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.common.JwtProperties;
import com.yzunlp.qzfeng.common.JwtUtil;
import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import com.yzunlp.qzfeng.domain.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 9:31
 */

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/register")
    public Result register(@RequestBody RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        UserInfo userInfo = userService.login(loginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("userID", userInfo.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        LoginVO loginVO = LoginVO.builder()
                .phone(userInfo.getPhone())
                .token(token)
                .build();
        return Result.success(loginVO);
    }

    @PostMapping("/saveHealthStatus")
    public Result saveHealthStatus(@RequestBody UserHealth userHealth){
        userService.saveHealthStatus(userHealth);
        return Result.success();
    }
    @PostMapping("/propolisUsage")
    public Result propolisUsage(@RequestBody UserPropolis userPropolis){
        userPropolis.setUpdateTime(LocalDateTime.now());
        //TODO
        //缺少userPropolis.setUserId() 完善登录接口后实现

        userService.savePropolisUsage(userPropolis);
        return Result.success();
    }





}
