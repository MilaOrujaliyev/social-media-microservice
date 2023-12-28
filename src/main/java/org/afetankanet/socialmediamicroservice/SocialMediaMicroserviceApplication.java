package org.afetankanet.socialmediamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableJpaRepositories(basePackages = "org.afetankanet.socialmediamicroservice.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "org.afetankanet.socialmediamicroservice.repository.elasticsearch")
public class SocialMediaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaMicroserviceApplication.class, args);
	}

}
