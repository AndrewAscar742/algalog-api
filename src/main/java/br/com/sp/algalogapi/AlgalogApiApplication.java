package br.com.sp.algalogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Algalog API", 
		description = "Sistema Delivery em que realiza o CRUD na qual o cliente realiza uma entrega para um destinatário" ,
		version = "2.7.8",
		termsOfService = "Termo de uso: OpenSource",
		license = @License(name = "Github: AndrewAscar742", 
			url = "http://localhost:8080/{recurso}"),
		contact = @Contact(name = "Andrew Matos Ascar", 
			email = "andrewmatosascar@outlook.com")))
public class AlgalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgalogApiApplication.class, args);
	}

}
