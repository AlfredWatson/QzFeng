package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.service.UserInfoService;
import com.yzunlp.qzfeng.common.BaseContext;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    private static final String UPLOAD_DIR = "D:\\develop_cocos\\JavaProjects\\QzFeng\\src\\main\\resources\\uploads\\";

    private final UserInfoService userService;
    private final JwtProperties jwtProperties;

    @Autowired
    public UserInfoController(UserInfoService userService, JwtProperties jwtProperties) {
        this.userService = userService;
        this.jwtProperties = jwtProperties;
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result<Void> register(@RequestBody RegisterDTO registerDTO) {
        log.info("用户注册: {}", registerDTO);
        int rows = userService.register(registerDTO);
        if (rows == 0) {
            log.info("用户已存在");
            return Result.error("注册失败");
        } else {
            log.info("注册成功: {}", registerDTO);
            return Result.success();
        }
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        log.info("用户登录: {}", loginDTO);
        UserInfo userInfo = userService.login(loginDTO);

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

    @Operation(summary = "用户填写健康信息")
    @PostMapping("/saveHealthStatus")
    public Result<Void> saveHealthStatus(@RequestBody UserHealth userHealth) {
        log.info("用户填写健康信息: {}", userHealth);
        userService.saveHealthStatus(userHealth);
        return Result.success();
    }

//    @Operation(summary = "用户填写蜂王胶使用情况")
//    @PostMapping("/savePropolisUsage")
//    public Result<Void> savePropolisUsage(@RequestBody UserPropolis userPropolis) {
//        log.info("用户填写蜂王胶使用情况: {}", userPropolis);
//        userPropolis.setUpdateTime(LocalDateTime.now());
//        userPropolis.setUserId(BaseContext.getCurrentId());
//        userService.savePropolisUsage(userPropolis);
//        return Result.success();
//    }
//
//    @Operation(summary = "用户填写蜂王胶使用主观体验")
//    @PostMapping("/saveEvaluation")
//    public Result<Void> saveEvaluation(@RequestBody UserEval userEval) {
//        log.info("用户填写蜂王胶使用主观体验: {}", userEval);
//        userEval.setUpdateTime(LocalDateTime.now());
//        userEval.setUserId(BaseContext.getCurrentId());
//        userService.saveEvaluation(userEval);
//        return Result.success();
//    }

    @Operation(summary = "用户上传体检报告（图片）")
    @PostMapping("/uploads")
    public Result<String> uploads(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {
            if (originalFilename != null) {
                // 利用UUID构造新的文件名称
                String objectName = UUID.randomUUID() + originalFilename;
                // 文件的请求路径
                String filePath = UPLOAD_DIR + objectName;
                String returnImagePate = "http://127.0.0.1:18080/images/" + objectName;
                file.transferTo(new File(filePath));
                UserCheckupForm userCheckupForm = new UserCheckupForm();
                userCheckupForm.setUserId(BaseContext.getCurrentId());
                userCheckupForm.setPicUrl(returnImagePate);
                userService.saveCheckUpForm(userCheckupForm);
                return Result.success(returnImagePate);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
        return Result.error("上传失败");
    }
}
