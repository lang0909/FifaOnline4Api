package org.LeeAn.fifaonline4.fifaonline4.service;


import lombok.extern.slf4j.Slf4j;
import org.LeeAn.fifaonline4.fifaonline4.api.FifaOnline4ApiClient;
import org.LeeAn.fifaonline4.fifaonline4.domain.TopRankerUsingAverage;
import org.LeeAn.fifaonline4.fifaonline4.repository.FifaOnline4ApiRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


@Service
@Slf4j
public class FifaOnline4ApiService {

    @Autowired
    FifaOnline4ApiClient fifaOnline4ApiClient;

    @Autowired
    FifaOnline4ApiRepository fifaOnline4ApiRepository;

    Long[] arr = null;
    JSONParser parser = new JSONParser();
    FifaOnline4ApiShellExecute fifaOnline4ApiShellExecute = new FifaOnline4ApiShellExecute();
    JSONArray jsonArray = null;
    int index = 0;
    {
        try {
            jsonArray = (JSONArray) parser.parse(new FileReader("./spid.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        arr= new Long[jsonArray.size()];
        for(int i=0;i<jsonArray.size();i++){
            JSONObject object = (JSONObject) jsonArray.get(i);
            arr[i] = (Long)object.get("id");
        }
    }

    @Scheduled(cron = "0 0 3 * * *")
    public void callAPImethod(){
        getFifaOnline4Api();
        index = 0;
        return;
    }

    public void getFifaOnline4Api() {
//        Usernickname usernickname = fifaOnline4ApiClient.requestUser("아주대학교");
//        UserTradeSellRecord[] userTradeSellRecord = fifaOnline4ApiClient.requestTradeSellRecord(usernickname.getAccessId(), "sell", 0, 20);
//        fifaOnline4ApiRepository.insertUserTradeSellRecord(userTradeSellRecord);
//        log.info("fifaonline4 api has been inserted successfully. {}", userTradeSellRecord);
        while(index<jsonArray.size()-1){
            try{
                JSONArray infoArray = new JSONArray();
                int temp = index+5;
                while(index<temp){
                    for(int j=1;j<29;j++){
                        JSONObject info = new JSONObject();
                        info.put("id",arr[index]);
                        info.put("po",j);
                        infoArray.add(info);
                    }
                    index = index+1;
                }
                TopRankerUsingAverage[] topRankerUsingAverages = fifaOnline4ApiClient.requestTopRankerUsingAverage(50,infoArray);
                fifaOnline4ApiRepository.insertTopRankerUsingAverage(topRankerUsingAverages);
            } catch(Exception e){
                for(int k=index-5;k<index;k++){
                    System.out.println(arr[k]);
                }
            }
            log.info("success");
        }
        String cmds = "sh /home/ec2-user/springboot/test.sh";
        String[] callCmd = {"/bin/bash", "-c", cmds};
        Map map = fifaOnline4ApiShellExecute.execCommand(callCmd);
        System.out.println(map);
    }
}
