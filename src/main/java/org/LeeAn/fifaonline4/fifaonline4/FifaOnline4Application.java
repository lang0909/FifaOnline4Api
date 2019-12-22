package org.LeeAn.fifaonline4.fifaonline4;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class FifaOnline4Application {

	public static void main(String[] args) {
		SpringApplication.run(FifaOnline4Application.class, args);
	}

}
