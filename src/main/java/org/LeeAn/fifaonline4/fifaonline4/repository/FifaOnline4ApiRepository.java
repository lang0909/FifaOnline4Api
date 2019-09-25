package org.LeeAn.fifaonline4.fifaonline4.repository;

import org.LeeAn.fifaonline4.fifaonline4.domain.UserTradeSellRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FifaOnline4ApiRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertUserTradeSellRecord(UserTradeSellRecord[] userTradeSellRecords){
        for(int i=0;i<userTradeSellRecords.length;i++)
        {
            mongoTemplate.insert(userTradeSellRecords[i]);
        }
    }
}
