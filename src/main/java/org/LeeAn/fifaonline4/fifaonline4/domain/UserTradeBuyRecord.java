package org.LeeAn.fifaonline4.fifaonline4.domain;

import lombok.Data;

@Data
public class UserTradeBuyRecord {
    private final String tradeDate;
    private final String saleSn;
    private final int spId;
    private final int grade;
    private final int value;
}
