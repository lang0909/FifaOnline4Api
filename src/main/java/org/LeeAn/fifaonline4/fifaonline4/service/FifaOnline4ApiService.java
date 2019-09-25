package org.LeeAn.fifaonline4.fifaonline4.service;


import lombok.extern.slf4j.Slf4j;
import org.LeeAn.fifaonline4.fifaonline4.api.FifaOnline4ApiClient;
import org.LeeAn.fifaonline4.fifaonline4.domain.UserTradeSellRecord;
import org.LeeAn.fifaonline4.fifaonline4.domain.Usernickname;
import org.LeeAn.fifaonline4.fifaonline4.repository.FifaOnline4ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FifaOnline4ApiService {

    @Autowired
    FifaOnline4ApiClient fifaOnline4ApiClient;

    @Autowired
    FifaOnline4ApiRepository fifaOnline4ApiRepository;

    @Scheduled(fixedDelay = 10000L)
    public void getFifaOnline4Api(){
        Usernickname usernickname = fifaOnline4ApiClient.requestUser("아주대학교");
        UserTradeSellRecord[] userTradeSellRecord =  fifaOnline4ApiClient.requestTradeSellRecord(usernickname.getAccessId(),"sell",0,20);
        fifaOnline4ApiRepository.insertUserTradeSellRecord(userTradeSellRecord);
        log.info("fifaonline4 api has been inserted successfully. {}", userTradeSellRecord);
    }
}
