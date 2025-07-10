package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.dto.RegisterDTO;
import com.yzunlp.qzfeng.domain.dto.UserHome1stDTO;
import com.yzunlp.qzfeng.domain.dto.UserHomeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 10297
 * @since 2025/7/10 15:30
 */
@Slf4j
@RestController
@RequestMapping("/user/all")
@Tag(name = "user-all接口")
public class UserController {
    @Operation(summary = "用户第一次")
    @PostMapping("/saveAll")
    public Result<Void> saveAll(
            @RequestBody UserHome1stDTO userHome1stDTO
//            @RequestParam("picFile") MultipartFile picFile
    ) {
        log.info("用户fucking: {}", userHome1stDTO);
//        String originalFilename = picFile.getOriginalFilename();
//        log.info("用户fucking-pic: {}", originalFilename);
        // todo 保存 userHome1stDTO
        return Result.success();
    }

    @Operation(summary = "用户后续")
    @PostMapping("/saveQuestionnaires")
    public Result<Void> saveQuestionnaires(
            @RequestBody UserHomeDTO userHomeDTO
//            @RequestParam("picFile") MultipartFile picFile
    ) {
        log.info("用户fucking-2: {}", userHomeDTO);
//        String originalFilename = picFile.getOriginalFilename();
//        log.info("用户fucking-2-pic: {}", originalFilename);
        // todo 保存 userHomeDTO
        return Result.success();
    }
}
