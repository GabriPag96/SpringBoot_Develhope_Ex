package com.example.Ex_Library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LibraryController {

    CatalogList lista = new CatalogList();
    @GetMapping("/libri")
    public String libri(){
        return lista.addToList().toString();
    }

    @GetMapping("/libri/id")
    public String searchForId(@RequestParam int id){
        for (BookConstructor bookConstructor : lista.addToList()){
            if(bookConstructor.getId() == id){
                return bookConstructor.toString();
            }
        }
        return null;
    }

    @GetMapping("/libri/genere")
    public String searchForGenere(@RequestParam String genere){
        List<BookConstructor> listaPerGenere = new ArrayList<>();
        for (BookConstructor bookConstructor : lista.addToList()){
            if (bookConstructor.getGenere().equals(genere)){
                listaPerGenere.add(bookConstructor);
            }
        }
        return listaPerGenere.toString();
    }
}
