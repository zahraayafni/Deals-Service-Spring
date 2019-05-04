package id.ac.its.pbkkddealsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ComponentScan("id.ac.its")
@SpringBootApplication
public class PbkkdDealsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbkkdDealsServiceApplication.class, args);
	}

}
