package com.example.Ex_Library;

import java.util.ArrayList;
import java.util.List;

public class CatalogList {
    private List<BookConstructor> bookList = new ArrayList<>();

    public List<BookConstructor> addToList(){

        bookList.add(new BookConstructor(1,"Il Signore Degli Anelli","Fantasy","J.R.R. Tolkien"));
        bookList.add(new BookConstructor(2,"Harry Potter","Fantasy","J.K. Rowling"));
        bookList.add(new BookConstructor(3,"The Hunger games Saga","Fantasy","Suzanne Collins"));
        bookList.add(new BookConstructor(4,"La critica della ragion pura", "Filosofia","Immanuel Kant"));


        return bookList;
    }

}
