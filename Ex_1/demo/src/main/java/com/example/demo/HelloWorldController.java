package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/V1")
@RestController
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping("/ciao")
    public String ciao(@RequestParam String nome){
        return "Ciao! Il mio nome è "+ nome;
    }
}
