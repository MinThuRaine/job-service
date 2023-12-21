package com.minthuraine.job.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.minthuraine.job.system"})
public class JobServiceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobServiceSystemApplication.class, args);
	}

}
