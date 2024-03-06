package it.example.Interceptor01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class BasicController {

    @GetMapping
    public String getCurrentTime() {
        return "Current date and time" + java.time.LocalDateTime.now();
    }

}
