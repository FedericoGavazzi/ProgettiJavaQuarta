/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es21gavazzipotettu;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gavazzi & Potettu
 */
public class Libro implements Serializable{

    private String ISBN;
    private String titolo;
    private String autore;
    private String casaEditrice;
    private int annoPubblicazione;

    public Libro() {
        ISBN = "";
        titolo = "";
        autore = "";
        casaEditrice = "";
        //generp il codice ISBN
        for (int i = 0; i < 13; i++) {
            this.ISBN += (char) ((int) '0' + (int) (Math.random() * 10));
        }
        //genero l-anno di pubblicazione
        this.annoPubblicazione = 1900 + (int) (Math.random() * 120);
        //genero l'autore del libro
        int l = (int) (Math.random() * 6) * 2 + 2;
        String vocali = "aeiou";
        String consonanti = "bcdfglmnprstvz";
        for (int i = 0; i < l; i++) {
            if (i % 2 == 0) {
                this.autore += consonanti.charAt((int) (Math.random() * consonanti.length()));
            } else {
                this.autore += vocali.charAt((int) (Math.random() * vocali.length()));
            }
        } 
        this.autore = this.autore.substring(0, 1).toUpperCase() + this.autore.substring(1);
        //genero il titolo del libro
        l = (int) (Math.random() * 6) * 2 + 2;
        for (int i = 0; i < l; i++) {
            if (i % 2 == 0) {
                this.titolo += consonanti.charAt((int) (Math.random() * consonanti.length()));
            } else {
                this.titolo += vocali.charAt((int) (Math.random() * vocali.length()));
            }
        }
        this.titolo = this.titolo.substring(0, 1).toUpperCase() + this.titolo.substring(1);
        //genero la casa editrice
        l = (int) (Math.random() * 12)* 2 + 2;
        for (int i = 0; i < l; i++) {
            if (i % 2 == 0) {
                this.casaEditrice += consonanti.charAt((int) (Math.random() * consonanti.length()));
            } else {
                this.casaEditrice += vocali.charAt((int) (Math.random() * vocali.length()));
            }
        }
        this.casaEditrice = this.casaEditrice.substring(0, 1).toUpperCase() + this.casaEditrice.substring(1);
    }

    public Libro(String ISBN, String titolo, String autore, String casaEditrice, int annoPubblicazione) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Titolo=" + titolo + "\nAutore=" + autore + "\nCasa editrice=" + casaEditrice +
                "\nAnno di pubblicazione=" + annoPubblicazione + "\nCodice ISBN=" + ISBN + "\n";
    }
    
    
    
}
