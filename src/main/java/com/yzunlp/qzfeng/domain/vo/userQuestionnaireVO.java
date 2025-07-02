package com.yzunlp.qzfeng.domain.vo;

import com.yzunlp.qzfeng.domain.po.UserCheckupForm;
import com.yzunlp.qzfeng.domain.po.UserEval;
import com.yzunlp.qzfeng.domain.po.UserPropolis;
import lombok.Data;

import java.util.List;

/**
 * @author 10297
 * @since 2025/7/2 13:22
 */
@Data
public class userQuestionnaireVO {
    private List<UserPropolis> userPropolisList;
    private List<UserEval> userEvalListerEval;
    private List<UserCheckupForm> userCheckupFormList;

    public userQuestionnaireVO() {
    }

    public userQuestionnaireVO(
            List<UserPropolis> userPropolisList,
            List<UserEval> userEvalListerEval,
            List<UserCheckupForm> userCheckupFormList
    ) {
        this.userPropolisList = userPropolisList;
        this.userEvalListerEval = userEvalListerEval;
        this.userCheckupFormList = userCheckupFormList;
    }
}
