package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class SalutoController {

    @GetMapping("/ciao/Lombardia")
    public Saluto ciao(@RequestParam String nome){
        String provincia = "Lombardia";
        String saluto = null;

        return new Saluto (nome, provincia, saluto);
    }
}
