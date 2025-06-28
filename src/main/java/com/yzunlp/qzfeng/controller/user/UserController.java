package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.common.JwtProperties;
import com.yzunlp.qzfeng.common.JwtUtil;
import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.dto.LoginDTO;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.po.*;
import com.yzunlp.qzfeng.domain.vo.LoginVO;
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
        userPropolis.setUserId(BaseContext.getCurrentId());
        userService.savePropolisUsage(userPropolis);
        return Result.success();
    }
    @PostMapping("/evaluation")
    public Result evaluation(@RequestBody UserEval userEval){
        userEval.setUpdateTime(LocalDateTime.now());
        userEval.setUserId(BaseContext.getCurrentId());
        userService.saveEvaluation(userEval);
        return Result.success();
    }
    @PostMapping("/uploads")
    public Result uploads(@RequestParam("file")MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        try {
            if (originalFilename != null) {
                // 利用UUID构造新的文件名称
                String objectName = UUID.randomUUID().toString() + originalFilename;
                // 文件的请求路径
                String filePath = "D:\\Code\\QzFeng\\src\\main\\resources\\uploads\\" + objectName;
                String returnImagePate = "http://127.0.0.1:18080/images/" + objectName;
                file.transferTo(new File(filePath));
                UserCheckupForm userCheckupForm = new UserCheckupForm();
                userCheckupForm.setUserId(BaseContext.getCurrentId());
                userCheckupForm.setPicUrl(returnImagePate);
                userService.saveCheckUp(userCheckupForm);
                return Result.success(returnImagePate);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
        return Result.error("上传失败");
    }






}
