package com.example.Ex_Library;

public class BookConstructor {
    private int id;
    private String titolo;
    private String genere;
    private String autore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public BookConstructor(int id, String titolo, String genere, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.genere = genere;
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", genere='" + genere + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}
