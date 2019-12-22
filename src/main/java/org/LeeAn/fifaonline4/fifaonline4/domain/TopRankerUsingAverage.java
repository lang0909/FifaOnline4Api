package org.LeeAn.fifaonline4.fifaonline4.domain;

import lombok.Data;

@Data
public class TopRankerUsingAverage {

    private int spId;
    private int spPosition;
    private RankerPlayerStatDTO status;
    private String createDate;


    @Data
    public static class RankerPlayerStatDTO{
        private float shoot;
        private float effectiveShoot;
        private float assist;
        private float goal;
        private float dribble;
        private float passTry;
        private float passSuccess;
        private float block;
        private float tackle;
        private int matchCount;
    }
}
