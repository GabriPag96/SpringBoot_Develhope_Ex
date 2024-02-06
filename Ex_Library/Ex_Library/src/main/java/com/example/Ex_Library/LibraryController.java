package com.example.Ex_Library;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/libri/{id}")
    public String searchForId(@PathVariable int id){
        for (BookConstructor bookConstructor : lista.addToList()){
            if(bookConstructor.getId() == id){
                return bookConstructor.toString();
            }
        }
        return null;
    }

    @GetMapping("/libri/{genere}")
    public String searchForGenere(@PathVariable String genere){
        List<BookConstructor> listaPerGenere = new ArrayList<>();
        for (BookConstructor bookConstructor : lista.addToList()){
            if (bookConstructor.getGenere().equals(genere)){
                listaPerGenere.add(bookConstructor);
            }
        }
        return listaPerGenere.toString();
    }
}
