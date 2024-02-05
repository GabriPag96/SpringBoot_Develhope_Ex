package com.example.demo;

public class Saluto {
    String nome;
    String provincia;
    String saluto;

    public Saluto(String nome, String provincia, String saluto){
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getProvincia(){
        return provincia;
    }

    public void setProvincia(String provincia){
        this.provincia = provincia;
    }

    public String getSaluto(){
        return saluto;
    }

    public void setSaluto(String saluto){
        this.saluto = saluto;
    }
}
