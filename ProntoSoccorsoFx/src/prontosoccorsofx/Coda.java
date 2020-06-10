/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prontosoccorsofx;

/**
 *
 * @author Federico Gavazzi
 */
public class Coda {

    private Sequenza s = new Sequenza();

    public int Size() {
        return s.numeroNodi();
    }

    public boolean isEmpty() {
        return s.numeroNodi() == 0;
    }

    public void Push(Paziente a) {
        s.inserimentoInCoda(a);
    }

    public Nodo Pop() {
        return s.cancellazioneInTesta();
    }
    
    public Paziente getPrimoPaziente(){
        return s.getItem(0);
    }
    
    @Override
    public String toString(){
        return s.toString();
    }
    
    public String listaNomi(String cod){
        return s.toStringNome(cod);
    }
    
    public String listaCognomi(){
        return s.toStringCognome();
    }
    
    public String listaCodici(){
        return s.toStringCodice();
    }

}
