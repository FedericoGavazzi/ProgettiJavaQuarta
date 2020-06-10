/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prontosoccorsofx;

/**
 *
 * @author Alessandro Bugatti
 */
public class Nodo {
    private Paziente info;
    private Nodo next;

    public Nodo(Paziente i){
        info=i;
        next=null;
    }
    
    public Paziente getInfo() {
        return info;
    }

    public void setInfo(Paziente info) {
        this.info = info;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
    
    
    
}
