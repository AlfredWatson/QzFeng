package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.common.BaseContext;
import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.po.UserCheckupForm;
import com.yzunlp.qzfeng.service.UserCheckupFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 10297
 * @since 2025/7/1 16:57
 */
@Tag(name = "user-checkup接口")
@Slf4j
@RestController
@RequestMapping("/user/checkup")
public class UserCheckupFormController {

    private static final String UPLOAD_DIR = "D:\\develop_cocos\\JavaProjects\\QzFeng\\src\\main\\resources\\uploads\\";
//    private static final String UPLOAD_DIR = "D:\\Code\\QzFeng\\src\\main\\resources\\uploads\\";

    @Autowired
    private UserCheckupFormService checkupFormService;

    /**
     * 添加体检单图片地址
     */
    @Operation(summary = "用户上传体检报告（图片）")
    @PostMapping("/uploads")
    public Result<UserCheckupForm> addCheckupForm(@RequestParam("file") MultipartFile file) {
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
                checkupFormService.add(userCheckupForm);
                return Result.success(userCheckupForm);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return Result.error("上传失败");
    }

    /**
     * 更新体检单图片地址
     */
    @PutMapping
    public Result<Void> updateCheckupForm(@RequestBody UserCheckupForm checkupForm) {
        checkupFormService.update(checkupForm);
        return Result.success(null);
    }

    /**
     * 查询用户的体检单信息
     */
    @GetMapping("/{userId}")
    public Result<UserCheckupForm> getCheckupForm(@PathVariable Long userId) {
        UserCheckupForm form = checkupFormService.getByUserId(userId);
        return Result.success(form);
    }
}
