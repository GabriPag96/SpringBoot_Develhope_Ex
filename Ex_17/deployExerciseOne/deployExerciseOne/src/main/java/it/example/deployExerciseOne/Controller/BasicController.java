package it.example.deployExerciseOne.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/devname")
    public String getDevName(){

        return "Gabriele";
    }
}
