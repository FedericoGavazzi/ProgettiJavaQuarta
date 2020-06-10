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
public class Prestito implements Serializable{
    private Libro libro;
    private Socio socio;
    
    public Prestito(Libro l, Socio s){
        libro = l;
        socio = s;
    }

    public Socio getSocio(){
        return socio;
    }
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Prestito other = (Prestito) obj;
        if (!Objects.equals(this.socio, other.socio)) {
            return false;
        }
        return true;
    }

    public boolean ricercaSocio(Object obj){
        return this.socio.equals(obj);
        }

    
    @Override
    public String toString(){
        return "Il Libro:\n" + libro.toString() + "è in prestito a\n" + socio.toString();
    }
}
