/*Sviluppare un'applicazione Spring Boot per la gestione dei libri. L'applicazione dovrebbe fornire tre endpoint REST per soddisfare le seguenti operazioni:

Recupero di un libro tramite ID:
GET /api/libri/{id}
Questo endpoint restituisce le informazioni di un libro specifico in base al suo ID.

Recupero di tutti i libri:
GET /api/libri
Questo endpoint restituisce un elenco di tutti i libri presenti nel catalogo.

Recupero di libri per genere:
GET /api/libri/genere/{genere}
Questo endpoint restituisce un elenco di libri appartenenti al genere specificato.*/

package com.example.Ex_Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExLibraryApplication.class, args);
	}

}
