package org.LeeAn.fifaonline4.fifaonline4.config;


import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate createMongoTemplate(){
        return new MongoTemplate(new MongoClient(), "fifaonline-top10000");
    }
}
