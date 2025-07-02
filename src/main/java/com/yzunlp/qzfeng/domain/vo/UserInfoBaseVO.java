package com.yzunlp.qzfeng.domain.vo;

import lombok.Data;

/**
 * @author 10297
 * @since 2025/7/2 13:09
 */
@Data
public class UserInfoBaseVO {
    private Long id; // 用户的唯一标识码
    private String phone; // 用户的电话，唯一
    private String name; // 用户的姓名

    public UserInfoBaseVO() {
    }

    public UserInfoBaseVO(Long id, String phone, String name) {
        this.id = id;
        this.phone = phone;
        this.name = name;
    }
}
