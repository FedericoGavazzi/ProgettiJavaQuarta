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
public class Socio implements Serializable{

    private String codiceFiscale;
    private String nome;
    private String cognome;

    public Socio() {
        codiceFiscale = "";
        nome = "";
        cognome = "";
        //genero il codice fiscale
        for (int i = 0; i < 16; i++)
            if (i%2 == 0)
                this.codiceFiscale += (char)((int)'A' +(int)(Math.random()*26));
            else
                this.codiceFiscale += (char)((int)'0' +(int)(Math.random()*10));
        //genero il nome
        int l = (int)(Math.random()*6)*2+2;
        String vocali = "aeiou";
        String consonanti = "bcdfglmnprstvz";
        for (int i = 0; i < l; i++)
            if (i%2 == 0)
                this.nome += consonanti.charAt((int)(Math.random()*consonanti.length()));
            else
                this.nome += vocali.charAt((int)(Math.random()*vocali.length()));
        this.nome = this.nome.substring(0, 1).toUpperCase() + this.nome.substring(1);

        //genero il cognome
        l = (int)(Math.random()*6)*2+2;
        for (int i = 0; i < l; i++)
            if (i%2 == 0)
                this.cognome += consonanti.charAt((int)(Math.random()*consonanti.length()));
            else
                this.cognome += vocali.charAt((int)(Math.random()*vocali.length()));
        this.cognome = this.cognome.substring(0, 1).toUpperCase() + this.cognome.substring(1);
    }

    public Socio(String codiceFiscale, String Nome, String Cognome) {
        this.codiceFiscale = codiceFiscale;
        this.nome = Nome;
        this.cognome = Cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    
    public String getCodiceFiscale(){
        return codiceFiscale;
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
        final Socio other = (Socio) obj;
        if (!Objects.equals(this.codiceFiscale, other.codiceFiscale)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "Nome " + nome + "\nCognome " + cognome + "\nCodice fiscale " + codiceFiscale + "\n";
    }

}
