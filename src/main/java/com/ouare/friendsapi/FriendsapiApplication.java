package com.ouare.friendsapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class FriendsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsapiApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner runner(FriendRepository friendRepository){
		return args -> {
			friendRepository.save(new Friend(null,"ouare","kouka","Informatique","koukaouare@gmail.com","Burkina Faso"));
			friendRepository.save(new Friend(null,"Gambo","Mounirou","Médécine","mounirougambo@gmail.com","Burkina Faso"));
			friendRepository.save(new Friend(null,"Yelemkoure","Vonka","Génie civile","yelemcoureyac@gmail.com","Burkina Faso"));
			friendRepository.save(new Friend(null,"Bonsa","Mariam","Néant","mariambonsa@gmail.com","Burkina Faso"));
		};
	}*/
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
								.description("Gestion de friend API documentation")
								.title("Gestion de friend REST API")
								.build()
				)
				.groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ouare.friendsapi"))
				.paths(PathSelectors.any())
				.build();
	}
}
