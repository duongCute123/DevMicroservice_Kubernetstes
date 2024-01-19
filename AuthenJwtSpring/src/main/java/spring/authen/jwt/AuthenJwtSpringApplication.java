package spring.authen.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenJwtSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenJwtSpringApplication.class, args);
	}

}
