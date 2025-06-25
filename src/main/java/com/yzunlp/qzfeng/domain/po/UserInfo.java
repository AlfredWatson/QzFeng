package com.yzunlp.qzfeng.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 10297
 * @since 2025/6/25 23:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id; // 用户的唯一标识码
    private String phone; // 用户的电话，唯一
    private String name = "户晨风"; // 用户的姓名
    private String password = "yzunlp"; // 用户的密码
    private String chinaId; // 用户的身份证号
    private Date birthday; // 用户的生日
    private Boolean sex; // 用户的性别，男1，女2
    private Long areaCode; // 用户所在地区编码
}
