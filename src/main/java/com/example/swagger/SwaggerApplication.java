package com.example.swagger;

import com.example.swagger.common.HttpComponent;
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

		HttpComponent hc = HttpComponent.getHttpComponent(HttpMode.TEST);
		System.out.println("hc TEST = " + hc);
		HttpComponent hc1 = HttpComponent.getHttpComponent(HttpMode.PRODUCTON);
		System.out.println("hc PRODUCTON = " + hc1);

	}
}
