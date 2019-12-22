package org.LeeAn.fifaonline4.fifaonline4.repository;

import org.LeeAn.fifaonline4.fifaonline4.domain.TopRankerUsingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class FifaOnline4ApiRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertTopRankerUsingAverage(TopRankerUsingAverage[] topRankerUsingAverages){
        for(int i=0;i<topRankerUsingAverages.length;i++)
        {
            TopRankerUsingAverage temp = null;
            Query query = new Query();
            query.addCriteria(Criteria.where("spId").is(topRankerUsingAverages[i].getSpId()).andOperator(Criteria.where("spPosition").is(topRankerUsingAverages[i].getSpPosition())));
            temp = mongoTemplate.findOne(query,TopRankerUsingAverage.class);
            if(temp==null){
                mongoTemplate.insert(topRankerUsingAverages[i]);
            }else {
                if(temp.getCreateDate().equals(topRankerUsingAverages[i].getCreateDate()))
                    continue;
                else{
                    temp.getStatus().setAssist(((topRankerUsingAverages[i].getStatus().getAssist()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getAssist()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setGoal(((topRankerUsingAverages[i].getStatus().getGoal()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getGoal()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setBlock(((topRankerUsingAverages[i].getStatus().getBlock()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getBlock()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setDribble(((topRankerUsingAverages[i].getStatus().getDribble()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getDribble()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setEffectiveShoot(((topRankerUsingAverages[i].getStatus().getEffectiveShoot()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getEffectiveShoot()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setPassSuccess(((topRankerUsingAverages[i].getStatus().getPassSuccess()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getPassSuccess()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setPassTry(((topRankerUsingAverages[i].getStatus().getPassTry()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getPassTry()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setShoot(((topRankerUsingAverages[i].getStatus().getShoot()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getShoot()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setTackle(((topRankerUsingAverages[i].getStatus().getTackle()*topRankerUsingAverages[i].getStatus().getMatchCount())+(temp.getStatus().getTackle()*temp.getStatus().getMatchCount()))/(temp.getStatus().getMatchCount()+topRankerUsingAverages[i].getStatus().getMatchCount()));
                    temp.getStatus().setMatchCount(topRankerUsingAverages[i].getStatus().getMatchCount()+temp.getStatus().getMatchCount());
                    temp.setCreateDate(topRankerUsingAverages[i].getCreateDate());
                    mongoTemplate.findAndReplace(query,temp);
                }
            }
        }
    }
}
