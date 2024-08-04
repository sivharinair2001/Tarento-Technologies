package com.tarento.EmployeeTask;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTaskApplication.class, args);
	}

}
