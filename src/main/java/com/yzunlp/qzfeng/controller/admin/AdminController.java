package com.yzunlp.qzfeng.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10297
 * @since 2025/7/1 14:47
 */
@Slf4j
@RestController
@RequestMapping("/admin")
@Tag(name = "admin接口")
public class AdminController {
    // todo 查询（分页）全部用户的 UserInfoBaseVO 信息，返回 UserInfoBaseVO

    // todo 根据用户id（前端传入 PathVariable） 查询 一个用户的 UserInfoHealthVO 信息，返回 UserInfoHealthVO

    // todo 根据用户id（前端传入 PathVariable） 查询 一个用户的 所有填写过的问卷信息，返回 userQuestionnaireVO (List数据条目 根据日期降序)
}
