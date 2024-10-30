package com.abrar.config;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQAslClient {
	
	@Autowired
	private Environment environ;
	
	
	@Bean
	 HttpGraphQlClient httpGraphQlClient()
	{
		return HttpGraphQlClient.builder(webClient()).build();
	}
	
	
	@Bean
	 WebClient webClient()
	{
		return WebClient
				.builder()
				.baseUrl(Objects.requireNonNull(environ.getProperty("graphQl.server.url")))
				.build();
	}

}
