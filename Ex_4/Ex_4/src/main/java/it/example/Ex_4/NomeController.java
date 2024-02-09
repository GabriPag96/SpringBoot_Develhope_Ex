package it.example.Ex_4;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NomeController {

    @ApiResponse(description = "Comando per l'input del nome")
    @GetMapping("/getName")
    public String getName(@RequestParam String name){ return "Il nome fornito è: " + name; }

    @ApiResponse(description = "Comando per il reverse del nome in input")
    @PostMapping("/reverseName")
    public String reverseName(@RequestParam String name){

        StringBuilder reversedName = new StringBuilder(name).reverse();
        return "Il nome al contrario è: " + reversedName.toString();

    }
}
