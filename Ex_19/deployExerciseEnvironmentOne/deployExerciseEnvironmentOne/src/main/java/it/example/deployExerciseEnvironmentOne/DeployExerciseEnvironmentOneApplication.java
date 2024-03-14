package it.example.deployExerciseEnvironmentOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DeployExerciseEnvironmentOneApplication {

	@Value("${authCode}")
	private String authCode;

	@Value("${devName}")
	private String devName;

	public static void main(String[] args) {
		SpringApplication.run(DeployExerciseEnvironmentOneApplication.class, args);
	}

	@GetMapping("/")
	public String greetings(){
		return "Hello, " + devName + "! Your auth code is: " + authCode;
	}
}
