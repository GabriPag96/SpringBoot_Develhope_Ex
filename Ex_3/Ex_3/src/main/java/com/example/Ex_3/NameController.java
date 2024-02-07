package com.example.Ex_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/getName")
    public String getName(@RequestParam String name){
        return "Il tuo nome è: " + name;
    }

    @PostMapping("/reverseName")
    public String reverseName(@RequestParam String name){
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return "Il tuo nome al contrario è: " + reversedName;
    }
}
