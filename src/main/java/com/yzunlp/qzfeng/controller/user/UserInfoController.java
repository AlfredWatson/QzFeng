package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.domain.dto.UserInfoDTO;
import com.yzunlp.qzfeng.service.UserInfoService;
import com.yzunlp.qzfeng.common.JwtProperties;
import com.yzunlp.qzfeng.common.JwtUtil;
import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;
import com.yzunlp.qzfeng.domain.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 9:31
 */
@Slf4j
@RestController
@RequestMapping("/user/info")
@Tag(name = "user-info接口")
public class UserInfoController {

//    private static final String UPLOAD_DIR = "D:\\develop_cocos\\JavaProjects\\QzFeng\\src\\main\\resources\\uploads\\";

    private final UserInfoService userInfoService;
    private final JwtProperties jwtProperties;

    @Autowired
    public UserInfoController(UserInfoService userService, JwtProperties jwtProperties) {
        this.userInfoService = userService;
        this.jwtProperties = jwtProperties;
    }

    @Operation(summary = "用户注册（增加用户）")
    @PostMapping("/register")
    public Result<Void> register(@RequestBody RegisterDTO registerDTO) {
        log.info("用户注册: {}", registerDTO);
        int rows = userInfoService.register(registerDTO);
        if (rows == 0) {
            log.info("用户已存在");
            return Result.error("注册失败");
        } else {
            log.info("注册成功: {}", registerDTO);
            return Result.success();
        }
    }

    @Operation(summary = "修改用户信息")
    @PutMapping
    public Result<Void> updateUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        log.info("用户修改信息: {}", userInfoDTO);
        userInfoService.updateUserInfo(userInfoDTO);
        return Result.success();
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        log.info("用户登录: {}", loginDTO);
        UserInfo userInfo = userInfoService.login(loginDTO);

        if (userInfo == null) {
            log.info("用户不存在");
            return Result.error("用户名或密码错误");
        }
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("userID", userInfo.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        LoginVO loginVO = LoginVO.builder()
                .phone(userInfo.getPhone())
                .token(token)
                .build();
        return Result.success(loginVO);
    }

}
