package com.yzunlp.qzfeng.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 15:14
 */
@Data
public class RegisterDTO {
    private String phone; // 用户的电话，唯一
    private String name; // 用户的姓名
    private String password = "yzunlp"; // 用户的密码
    private String chinaId; // 用户的身份证号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; // 用户的生日
    private Boolean sex; // 用户的性别，男1，女2
    private Long areaCode; // 用户所在地区编码

    public RegisterDTO() {
    }

    public RegisterDTO(String phone, String name, String password, String chinaId, Date birthday, Boolean sex, Long areaCode) {
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.chinaId = chinaId;
        this.birthday = birthday;
        this.sex = sex;
        this.areaCode = areaCode;
    }
}
