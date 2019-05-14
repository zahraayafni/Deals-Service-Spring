package id.ac.its.pbkkddealsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan("id.ac.its")
@EntityScan("id.ac.its.model")
@EnableJpaRepositories("id.ac.its.repository")
public class PbkkdDealsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbkkdDealsServiceApplication.class, args);
	}

}
