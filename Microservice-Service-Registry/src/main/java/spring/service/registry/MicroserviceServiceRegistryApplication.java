package spring.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServiceRegistryApplication.class, args);
	}

}
