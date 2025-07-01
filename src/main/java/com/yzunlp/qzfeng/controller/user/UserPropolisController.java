package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import com.yzunlp.qzfeng.service.UserPropolisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10297
 * @since 2025/7/1 16:54
 */
@Tag(name = "user-propolis接口")
@Slf4j
@RestController
@RequestMapping("/user/propolis")
public class UserPropolisController {

    @Autowired
    private UserPropolisService userPropolisService;

    /**
     * 添加蜂胶信息
     */
    @Operation(summary = "用户填写蜂王胶使用情况")
    @PostMapping
    public Result<Void> addUserPropolis(@RequestBody UserPropolis userPropolis) {
        log.info("用户填写蜂王胶使用情况: {}", userPropolis);
        userPropolisService.add(userPropolis);
        return Result.success(null);
    }

    /**
     * 更新蜂胶信息
     */
    @PutMapping
    public Result<Void> updateUserPropolis(@RequestBody UserPropolis userPropolis) {
        log.info("用户更新蜂王胶使用情况: {}", userPropolis);
        userPropolisService.update(userPropolis);
        return Result.success(null);
    }

    /**
     * 查询用户的蜂胶信息（最新一条）
     */
    @GetMapping("/{userId}")
    public Result<UserPropolis> getUserPropolis(@PathVariable Long userId) {
        log.info("查询 用户id={} 的蜂胶信息", userId);
        UserPropolis propolis = userPropolisService.getByUserId(userId);
        return Result.success(propolis);
    }
}
