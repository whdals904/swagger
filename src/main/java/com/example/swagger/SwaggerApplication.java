package com.example.swagger;

import com.example.swagger.common.http.HttpManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SwaggerApplication {


	public static void main(String[] args) throws IOException {

		SpringApplication.run(SwaggerApplication.class, args);
		HttpManager hc = HttpManager.getHttpComponent(HttpManager.HttpMode.TEST);
		HttpManager hc1 = HttpManager.getHttpComponent(HttpManager.HttpMode.PRODUCTON);
		List<HttpManager> list = Arrays.asList(hc, hc1);
		list.stream().forEach(System.out::println);

	}
}
