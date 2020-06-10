/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prontosoccorsofx;

/**
 *
 * @author 77785190
 */
public class Paziente {
    private String codice_sanitario;
    private String nome;
    private String cognome;
    private int numArrivo;
    
    public Paziente(String cod, String n, String c, int numArrivo){
        codice_sanitario=cod;
        nome=n;
        cognome=c;
        this.numArrivo=numArrivo;
    }
    
    public int getNumArrivo(){
        return numArrivo;
    }
    public void setNumArrivo(int n){
        numArrivo=n;
    }

    public String getCodice_sanitario() {
        return codice_sanitario;
    }

    public void setCodice_sanitario(String codice_sanitario) {
        this.codice_sanitario = codice_sanitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    @Override
    public String toString(){
        return "paziente " + cognome + " " + nome + "\n" + codice_sanitario +"\n";
    }
    public String toString2(){
        return nome + " " + cognome + " " + codice_sanitario + "\n"; 
    }
    
    
}
