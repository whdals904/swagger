package com.example.swagger;

import com.example.swagger.common.HttpManager;
import com.example.swagger.common.HttpMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@EnableJpaAuditing
@SpringBootApplication
public class SwaggerApplication {


	public static void main(String[] args) throws IOException {

		SpringApplication.run(SwaggerApplication.class, args);

		HttpManager hc = HttpManager.getHttpComponent(HttpMode.TEST);
		HttpManager hc1 = HttpManager.getHttpComponent(HttpMode.PRODUCTON);

	}
}
