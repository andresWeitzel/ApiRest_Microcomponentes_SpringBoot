package com.api.rest.microelectronica.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer{

	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build();
    }



    //"ApiRest Productos Supermercado v3.0"
    private ApiInfo apiInfo(){
        return new ApiInfo(
        		"ApiRest_MicroFront_Microelectrónica",
        		"\r\n"
        		+ "* Microservicio Api Rest para el Micro FrontEnd Microelectrónica implementado con Spring Boot, Spring MVC, Spring Data JPA, SpringFox, Swagger UI, Maven, Lombok, Postman, Log4j, Git, SQLDeveloper, Oracle XE 21c y Otras Tecnologías.\r\n"
        		+ "* Para este Microservicio no se implementa la capa de seguridad, es posible realizarlo con Spring Security (visualizar otras Api's Rest en mi perfíl de github).\r\n"
        		+ "* Se incluye documentación con Swagger 2 / Spring Fox para cada recurso junto con los códigos de respuesta Http más usados. Además se agrega doc junto con validaciones para cada Bean.\r\n"
        		+ "* Los Objetos de Búsqueda se trabajan como paginados, incluyendo algunos de tipo CRUD. Se implementa manejos de Excepciones con clases específicas para su control.\r\n"
        		+ "* Entre Otros.\r\n"
        		+ "* Repositorio App_MicroFront_Microelectronica_React_Oracle : https://github.com/andresWeitzel/App_MicroFront_Microelectronica_React_Oracle\r\n"
        		+ "* Repositorio db_microElectronica : https://github.com/andresWeitzel/db_microElectronica_OracleXE\r\n"
        		+ "* PlayList Api Rest : https://www.youtube.com/playlist?list=PLCl11UFjHurDnmm7zqPOgpPu0fAuOHa9S",
        	    "v3.0",
        	    "https://github.com/andresWeitzel/ApiRest_MicroFront_Microelectronica/blob/master/LICENSE",
                new Contact("Andrés Weitzel","https://github.com/andresWeitzel/ApiRest_MicroFront_Microelectronica" ,"andres96energy@hotmail.com"),
                "GNU v3.0",
                "https://github.com/andresWeitzel/ApiRest_MicroFront_Microelectronica/blob/master/LICENSE",
                Collections.emptyList()
        );
    }
	
	


}