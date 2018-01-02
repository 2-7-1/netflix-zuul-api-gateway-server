package com.rest.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}

	// Spring Cloud Sleuth dependency in .pom file plus this @Bean Enables Spring
	// Cloud Sleuth
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
