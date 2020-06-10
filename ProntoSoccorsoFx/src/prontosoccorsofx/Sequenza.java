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
public class Sequenza {

    private Nodo head;
    private int n_nodi;
    private Nodo tail;

    public Sequenza() {
        head = null;
        tail = null;
        n_nodi = 0;
    }

//    public void inserimentoInTesta(int n){
//        Nodo nuovo=new Nodo(n);
//        nuovo.setNext(head);
//        head=nuovo;
//        if(n_nodi==0)
//            tail=head;
//        n_nodi++;
//    }
    public Nodo cancellazioneInTesta() {
        if (head == null) {
            return null;
        }
        Nodo temp = head;
        head = head.getNext();
        n_nodi--;
        return temp;
    }

    public void inserimentoInCoda(Paziente p) {
        if (n_nodi == 0) {
            head = new Nodo(p);
            tail = head;
            n_nodi++;
            return;
        }

        Nodo nuovo = new Nodo(p);
        tail.setNext(nuovo);
        tail = nuovo;
        n_nodi++;
    }

    public Paziente getItem(int pos) {
        if (pos < 0 || pos > n_nodi - 1) {
            return null;
        }
        if (head == null) {
            return null;
        }
        Nodo temp = head;
        return temp.getInfo();
    }

    public int numeroNodi() {
        return n_nodi;
    }

    @Override
    public String toString() {
        if (n_nodi == 0) {
            return "";
        }
        String s = "" + head.getInfo().toString();
        Nodo temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            s += "" + temp.getInfo().toString();
        }
        return s;
    }

    public String toStringNome(String gravita) {       
        if (n_nodi == 0) {
            return "";
        }
        String s;
        if (gravita.equals("Rosso") || gravita.equals("Verde")) {
            s = gravita + "  " + head.getInfo().getNome() + "\n";
            Nodo temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                s += gravita + "  " + temp.getInfo().getNome() + "\n";
            }
        } else {
            s = gravita + " " + head.getInfo().getNome() + "\n";
            Nodo temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                s += gravita + " " + temp.getInfo().getNome() + "\n";
            }
            
        }
        return s;
    }

    

    public String toStringCognome() {
        if (n_nodi == 0) {
            return "";
        }
        String s = "" + head.getInfo().getCognome() + "\n";
        Nodo temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            s += "" + temp.getInfo().getCognome() + "\n";
        }
        return s;
    }

    public String toStringCodice() {
        if (n_nodi == 0) {
            return "";
        }
        String s = "" + head.getInfo().getCodice_sanitario() + "\n";
        Nodo temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            s += "" + temp.getInfo().getCodice_sanitario() + "\n";
        }
        return s;
    }
}
