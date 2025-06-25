package com.yzunlp.qzfeng.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10297
 * @since 2025/6/25 23:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info2Health {
    private Long infoId; // 外键--user_info--id
    private Long healthId; // 外键--user_health--id
    private Long id; // 唯一标识号
}
