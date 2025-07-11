package com.yzunlp.qzfeng.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 10297
 * @since 2025/7/10 14:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHome1stDTO {
    private String name; // 用户的姓名
    private String chinaId; // 用户的身份证号
    private Date birthday; // 用户的生日
    private Short sex; // 用户的性别，男1，女2
    private Long areaCode; // 用户所在地区编码

    private Boolean hypertension; // 是否有高血压
    private Integer hypertensionYear; // 高血压病程几年
    private Boolean hypertensionDrug; // 是否规律服药
    private Boolean diabetes; // 是否有糖尿病
    private Integer diabetesYear; // 糖尿病病程几年
    private Boolean diabetesDrug; // 是否规律服药
    private Boolean hyperlipidemia; // 是否有高血脂
    private Integer hyperlipidemiaYear; // 高血脂病程几年
    private Boolean hyperlipidemiaDrug; // 是否规律服药
    private Boolean tumor; // 是否有肿瘤

    private Boolean propolis; // 是否服用过蜂胶
    private Short propolisYear; // 从何时开始使用蜂胶
    private String propolisFrequency; // 蜂胶使用频率(单选: ABCD)

    private String evaluation; // 使用逗号分割，共六个评分(评分范围[0, 3])

    private String picUrl; // 体检单(图片)地址
}
