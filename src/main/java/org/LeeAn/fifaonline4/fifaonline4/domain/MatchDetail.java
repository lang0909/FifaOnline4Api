package org.LeeAn.fifaonline4.fifaonline4.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.lang.reflect.Array;

@Data
public class MatchDetail {
    @Id
    private MatchDTO matchDTO;
    private MatchInfoDTO matchInfoDTO;
    private MatchDetailDTO matchDetailDTO;
    private ShootDTO shootDTD;
    private ShootDetailDTO shootDetailDTO;
    private PassDTO passDTO;
    private DefenceDTO defenceDTO;
    private PlayerDTO playerDTO;
    private StatusDTO statusDTO;


    @Data
    public static class MatchDTO{
        private String matchId;
        private String matchDate;
        private int matchType;
        private Array matchInfo;
    }

    @Data
    public static class MatchInfoDTO{
        private String accessId;
        private String nickname;
        private MatchDetailDTO matchDetail;
        private ShootDTO shoot;
        private PassDTO pass;
        private DefenceDTO defence;
        private Array player;
    }

    @Data
    public static class MatchDetailDTO{
        private int seasonId;
        private String matchResult;
        private int matchEndType;
        private int systemPause;
        private int foul;
        private int injury;
        private int redCards;
        private int yellowCards;
        private int dribble;
        private int cornerKick;
        private int possession;
    }

    @Data
    public static class ShootDTO{
        private int shootTotal;
        private int effectiveShootTotal;
        private int shootOutScore;
        private int goalTotal;
        private int goalTotalDisplay;
        private int ownGoal;
        private int shootHeading;
        private int goalHeading;
        private int shootFreekick;
        private int goalFreekick;
        private int shootInPenalty;
        private int goalInPenalty;
        private int shootOutPenalty;
        private int goalOutPenalty;
        private int shootPenaltyKick;
        private int goalPenaltyKick;
    }

    @Data
    public static class ShootDetailDTO{
        private int goalTime;
        private double x;
        private double y;
        private int type;
        private int result;
        private boolean assist;
        private boolean hitPost;
        private boolean inPenalty;
    }

    @Data
    public static class PassDTO{
        private int passTry;
        private int passSuccess;
        private int shortPassTry;
        private int shortPassSuccess;
        private int longPassTry;
        private int longPassSuccess;
        private int bouncingLobPassTry;
        private int bouncingLobPassSuccess;
        private int drivenGroundPassTry;
        private int drivenGroundPassSuccess;
        private int throughPassTry;
        private int throughPassSuccess;
        private int lobbedThroughPassTry;
        private int lobbedThroughPassSuccess;
    }

    @Data
    public static class DefenceDTO{
        private int blockTry;
        private int blockSuccess;
        private int tackleTry;
        private int tackleSuccess;
    }

    @Data
    public static class PlayerDTO{
        private int spId;
        private int spPosition;
        private int spGrade;
        private StatusDTO status;
    }

    @Data
    public static class StatusDTO{
        private int shoot;
        private int effectiveShoot;
        private int assist;
        private int goal;
        private int dribble;
        private int passTry;
        private int passSuccess;
        private int block;
        private int tackle;
        private float spRating;
    }
}
