package br.edu.infnet.AppPetPatreon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppPetPatreonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPetPatreonApplication.class, args);
	}
}