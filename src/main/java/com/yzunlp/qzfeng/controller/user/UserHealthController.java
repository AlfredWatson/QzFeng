package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.service.UserHealthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10297
 * @since 2025/7/1 22:09
 */
@Tag(name = "user-health接口")
@Slf4j
@RestController
@RequestMapping("/user/health")
public class UserHealthController {

    private final UserHealthService userHealthService;

    @Autowired
    public UserHealthController(UserHealthService userHealthService) {
        this.userHealthService = userHealthService;
    }

    @Operation(summary = "用户填写(更新)健康信息")
    @PostMapping
    public Result<Void> saveUserHealth(@RequestBody UserHealth userHealth) {
        log.info("用户填写健康信息: {}", userHealth);
        userHealthService.saveUserHealth(userHealth);
        return Result.success();
    }
}
