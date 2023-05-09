package com.graphql.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.graphql.client.controller", "com.graphql.client.service"})
public class GraphQLClientWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQLClientWithSpringBootApplication.class, args);
	}

}
