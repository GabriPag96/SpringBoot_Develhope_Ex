package it.example.Ex_5;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class NameController {

    @GetMapping("/name")
    public String getName(@RequestParam String name){
        return name;
    }

    @PostMapping("/reverseName")
    public String getReverseName(@RequestParam String name){
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return reversedName.toString();
    }
}
