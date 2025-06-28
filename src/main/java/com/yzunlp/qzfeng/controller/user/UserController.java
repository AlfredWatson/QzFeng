package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.Service.UserService;
import com.yzunlp.qzfeng.domain.po.UserHealth;
import com.yzunlp.qzfeng.domain.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @PostMapping("/saveHealthStatus")
    public void saveHealthStatus(@RequestBody UserHealth userHealth){
        userService.save(userHealth);
    }




}
