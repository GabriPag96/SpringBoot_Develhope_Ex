package it.example.LoggingEx.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/")
    public String welcome(){

        logger.info("Welcome message requested");

        return "Welcome! Check the logs for the outputs.";
    }

    @GetMapping("/exp")
    public double calculatePower(){

        int base = 2;
        int exponent = 8;

        logger.debug("Calculating power: {} ^ {}", base, exponent);

        double result = Math.pow(base, exponent);

        logger.info("Power calculating result: {}", result);

        return result;
    }

    @GetMapping("/get-errors")
    public void throwCustomError(){

        logger.error("Custom error occurred");

        throw new RuntimeException("Custom error");
    }
}
