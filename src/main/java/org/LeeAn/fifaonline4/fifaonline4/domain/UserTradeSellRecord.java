package org.LeeAn.fifaonline4.fifaonline4.domain;

import lombok.Data;

@Data
public class UserTradeSellRecord {
    private String tradeDate;
    private String saleSn;
    private int spid;
    private int grade;
    private int value;
}
