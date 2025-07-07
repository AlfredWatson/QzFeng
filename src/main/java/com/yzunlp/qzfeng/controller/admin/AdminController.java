package com.yzunlp.qzfeng.controller.admin;

import com.yzunlp.qzfeng.common.PageResult;
import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.vo.UserInfoHealthVO;
import com.yzunlp.qzfeng.domain.vo.UserQuestionnaireVO;
import com.yzunlp.qzfeng.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10297
 * @since 2025/7/1 14:47
 */
@Slf4j
@RestController
@RequestMapping("/admin")
@Tag(name = "admin接口")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // todo 查询（分页）全部用户的 UserInfoBaseVO 信息，返回 UserInfoBaseVO
    @GetMapping("/userList")
    @Operation(summary = "查询（分页）全部用户")
    public Result<PageResult> getAllUsers(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "5") int pageSize
    ) {
        log.info("查询（分页）全部用户");
        return Result.success(adminService.getAllUsers(pageNum, pageSize));
    }

    // todo 根据用户id（前端传入 PathVariable） 查询 一个用户的 UserInfoHealthVO 信息，返回 UserInfoHealthVO
    @GetMapping("/getUserInfoHealthById/{id}")
    @Operation(summary = "查询用户信息与健康信息")
    public Result<UserInfoHealthVO> selectUserInfoHealthById(@PathVariable Long id) {
        log.info("查询用户信息与健康信息(user-id={})",  id);
        return Result.success(adminService.selectUserInfoHealthById(id));
    }

    // todo 根据用户id（前端传入 PathVariable） 查询 一个用户的 所有填写过的问卷信息，返回 userQuestionnaireVO (List数据条目 根据日期降序)
    @GetMapping("/getUserQuestionnaireById/{id}")
    @Operation(summary = "查询用户所有填写过的问卷信息")
    public Result<UserQuestionnaireVO> selectUserQuestionnaireById(@PathVariable Long id) {
        log.info("查询用户所有填写过的问卷信息(user-id={})",  id);
        return Result.success(adminService.selectUserQuestionnaireById(id));
    }

}
