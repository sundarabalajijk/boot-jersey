package com.poc.jersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.filter.OrderedRequestContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
public class JerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyApplication.class, args);
	}

	@Bean
	public RequestContextFilter requestContextFilter() {
		OrderedRequestContextFilter filter = new OrderedRequestContextFilter();
		filter.setOrder(-100001);
		return filter;
	}
}

