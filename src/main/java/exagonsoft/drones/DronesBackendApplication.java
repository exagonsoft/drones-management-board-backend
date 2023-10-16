package exagonsoft.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DronesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesBackendApplication.class, args);
	}

}
