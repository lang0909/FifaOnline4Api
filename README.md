# Spring Boot Application Using Nexon FifaOnline4Api

## 개요
넥슨의 OPEN API를 이용하여, 각 선수의 모든 포지션에 대한 정보를 받아오는 Spring boot application 입니다.

## 사용된 Dependencies & APIs
- Spring Framework
- Lombok - version 1.18.8
- [Nexon OPEN API](<https://developers.nexon.com/fifaonline4>)

## 사용 시 주의사항
### Api key를 확인

```java

@Service
public class FifaOnline4ApiClient {
    private final String api_key = ""; // <-자신의 Api key를 사용하세요.

```

이 Application을 사용하기 위해서 Api Key를 꼭 확인하세요. Nexon에서 제공하는 Development Api Key는 10초당 200,000번 이상 호출되면 Api key가 블락되니 주의하세요.

### Server Port를 확인
```properties
server.port = 8081
```
Application을 실행할 때, 사용하는 Server Port를 확인하고 원하시면 임의의 포트로 변경하세요. (resources/application.properties)

이 프로젝트에서는 `localhost:8081`을 통해 접속하실 수 있습니다


## 기능 설명
### API 사용 과정

```java

public void insertTopRankerUsingAverage(TopRankerUsingAverage[] topRankerUsingAverages){
        for(int i=0;i<topRankerUsingAverages.length;i++)
        {
            TopRankerUsingAverage temp = null;
            Query query = new Query();
            query.addCriteria(Criteria.where("spId").is(topRankerUsingAverages[i].getSpId()).andOperator(Criteria.where("spPosition").is(topRankerUsingAverages[i].getSpPosition())));
            temp = mongoTemplate.findOne(query,TopRankerUsingAverage.class);
            .
            .
            .

```
이 Application에서는 이미 저장되어있던 각 선수의 모든 포지션에 대한 정보를 불러와 현재 저장되어 있는 데이터의
업데이트 날짜와 동일하면 skip하고 아니면 정보를 업데이트 하는 형식으로 MongoDB에 데이터를 저장합니다.
