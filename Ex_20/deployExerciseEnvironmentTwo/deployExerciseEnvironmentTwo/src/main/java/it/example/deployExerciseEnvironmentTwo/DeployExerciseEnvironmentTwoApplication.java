package it.example.deployExerciseEnvironmentTwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DeployExerciseEnvironmentTwoApplication {

	@Value("${application.welcomeMsg}")
	private String welcomeMsg;

	public static void main(String[] args) {
		SpringApplication.run(DeployExerciseEnvironmentTwoApplication.class, args);
	}

	@GetMapping("/")
	public String greetings(){
		return welcomeMsg;
	}

}
