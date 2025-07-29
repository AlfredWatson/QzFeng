package com.yzunlp.qzfeng.controller.user;

import com.yzunlp.qzfeng.common.Result;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import com.yzunlp.qzfeng.domain.vo.YearPeopleVO;
import com.yzunlp.qzfeng.domain.vo.YesNoVO;
import com.yzunlp.qzfeng.service.UserPropolisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        log.debug("用户填写蜂王胶使用情况: {}", userPropolis);
        userPropolisService.add(userPropolis);
        return Result.success(null);
    }

    /**
     * 更新蜂胶信息
     */
    @PutMapping
    public Result<Void> updateUserPropolis(@RequestBody UserPropolis userPropolis) {
        log.debug("用户更新蜂王胶使用情况: {}", userPropolis);
        userPropolisService.update(userPropolis);
        return Result.success(null);
    }

    /**
     * 查询用户的蜂胶信息（最新一条）
     */
    @GetMapping("/{userId}")
    public Result<UserPropolis> getUserPropolis(@PathVariable("userId") Long userId) {
        log.debug("查询用户的蜂胶使用情况");
        UserPropolis propolis = userPropolisService.getByUserId(userId);
        return Result.success(propolis);
    }

    @Operation(summary = "统计用户使用蜂胶信息(吃过吗？)")
    @GetMapping("/admin/yes-no")
    public Result<YesNoVO> propolis() {
        log.debug("统计用户使用蜂胶信息(吃过吗？)");

        // Todo

        YesNoVO yesNoVO = new YesNoVO();
        yesNoVO.setYes(2);
        yesNoVO.setNo(58);
        return Result.success(yesNoVO);
    }

    @Operation(summary = "统计用户使用蜂胶信息(从什么时候开始吃的？)")
    @GetMapping("/admin/year")
    public Result<YearPeopleVO> propolisYear() {
        log.debug("统计用户使用蜂胶信息(从什么时候开始吃的？)");

        // Todo

        YearPeopleVO r = new YearPeopleVO();
        r.setYear(List.of(2000, 2004, 2015, 2007, 2012, 2014, 2015, 2016));
        r.setPeople(List.of(21, 13, 25, 3, 67, 82, 38, 8));
        return Result.success(r);
    }

    @Operation(summary = "统计用户使用蜂胶信息(吃的频率？)")
    @GetMapping("/admin/frequency")
    public Result<Map<String, Integer>> propolisFrequency() {
        log.debug("统计用户使用蜂胶信息(吃的频率？)");

        // Todo

        Map<String, Integer> r = Map.of("A", 2, "B", 5, "C", 7, "D", 12);
        return Result.success(r);
    }
}
