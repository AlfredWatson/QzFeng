package com.yzunlp.qzfeng.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Huang
 * @description: TODO
 * @date: 2025/6/28 14:42
 */
@Data
@Builder
public class LoginVO {
    private String phone;
    private String token;
}
