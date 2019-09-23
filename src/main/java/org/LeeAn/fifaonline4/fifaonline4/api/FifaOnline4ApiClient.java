package org.LeeAn.fifaonline4.fifaonline4.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FifaOnline4ApiClient {
    private final String user_nickname_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname={nickname}";
    private final String user_accessid_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users/{accessid}";
    private final String user_accessid_maxdivison_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users/{accessid}/maxdivision";
    private final String user_matchtype_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users/{accessid}/matches?matchtype={matchtype}&offset={offset}&limit={limit}";
    private final String user_tradetype_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users/{accessid}/markets?tradetype={tradetype}&offset={offset}&limit={limit}";
    private final String user_matchdetail_url = "https://api.nexon.co.kr/fifaonline4/v1.0/matches/{matchid}";
    private final String top10000_ranker_use_url = "https://api.nexon.co.kr/fifaonline4/v1.0/rankers/status?matchtype={matchtype}&players={players}";
    private final String api_key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiODIyMjE4NjgzIiwiYXV0aF9pZCI6IjIiLCJ0b2" +
            "tlbl90eXBlIjoiQWNjZXNzVG9rZW4iLCJzZXJ2aWNlX2lkIjoiNDMwMDExNDgxIiwiWC1BcHAtUmF0ZS1MaW1pdCI6IjIwMDAwOjEwIiwibmJmIjox" +
            "NTY3MDkxNjMzLCJleHAiOjE2MzAxNjM2MzMsImlhdCI6MTU2NzA5MTYzM30.rcv7fksQgEq-DElMRcUJAYEndUMjmLQU7OKjGpH5gVE";

    @Autowired
    RestTemplate restTemplate;

    public Usernickname requestUser(String user_nickname){

    }
}
