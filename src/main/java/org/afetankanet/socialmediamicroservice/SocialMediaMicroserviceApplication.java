package org.afetankanet.socialmediamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SocialMediaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaMicroserviceApplication.class, args);
	}

}
