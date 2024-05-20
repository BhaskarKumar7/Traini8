package com.traini8.gftc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	/***** creating swagger api documentation *****/
	@Bean
	public OpenAPI customOpenApi()	{
		Contact contact = new Contact();
		contact.setEmail("bhaskarkumar4994@gmail.com");
		contact.setName("Bhaskar kumar Aligi");
		contact.setUrl("To be generated.......");
		Info info = new Info();
		info.setTitle("Government Funded Training Centers Api");
		info.setDescription("This application is a minimum viable product for a registry "
				+ "of government funded training centers");
		info.setVersion("v1.0");
		info.setContact(contact);
		return new OpenAPI().info(info);
	}
}
