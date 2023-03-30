package com.testmongo.user;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The type User Application.
 */

@SpringBootApplication
@Log4j2
public class UserApplication {

	/**
	 * the main method.
	 *
	 * @param args arg
	 */
	public static void main(String[] args) {

		SpringApplication.run(UserApplication.class, args);
		log.info("The User Application has Started");
	}

	/**
	 * Custom open api open api.
	 *
	 * @return the open api
	 */
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(Type.HTTP).scheme("basic")))
				.info(new Info()
						.title("User")
						.description("User API Documentation "));
	}
}