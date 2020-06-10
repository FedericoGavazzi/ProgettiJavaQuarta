/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Es25Pag302;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feder
 */
public class AttivitaEconomiche implements Serializable {

    LinkedList<Operazione> operazioni = new LinkedList<>();

    public void nuovoIncasso(double importo, String motivazione) {
        operazioni.add(new Operazione(importo, motivazione, "Incasso"));
    }

    public void nuovaSpesa(double importo, String motivazione) {
        operazioni.add(new Operazione(importo, motivazione, "Spesa"));
    }

    public String elimina(int numeroOperazione) {
        int i = 0;
        for (Operazione a : operazioni) {
            if (a.getCodiceOperazione() == numeroOperazione) {
                operazioni.remove(i);
                return "È stata eliminata l'operazione";
            }
            i++;
        }
        return "Non è stata eliminata l'operazione";
    }

    public String visualizza(int numeroOperazione) {

        for (Operazione a : operazioni) {
            if (numeroOperazione == a.getCodiceOperazione()) {
                return a.toString();
            }
        }
        return null;
    }

    public String visualizza(double importo, String motivo) {
        for (Operazione a : operazioni) {
            if (a.getImporto() == importo && a.getMotivazione().equals(motivo)) {
                return a.toString();
            }
        }
        return null;
    }

    public String Salva() throws FileNotFoundException, IOException {
        
        FileOutputStream fo = new FileOutputStream("Data.bin");
        ObjectOutputStream outObj = new ObjectOutputStream(fo);
        outObj.writeObject(operazioni);
        return "Salvataggio effettuato nel file";
    }

    public String Carica() {
        String advertise;
        try {
            FileInputStream f = new FileInputStream("Data.bin");
            ObjectInputStream inObj = new ObjectInputStream(f);
            this.operazioni = (LinkedList<Operazione>) inObj.readObject();
            advertise = "I dati sono stati caricati con successo dal file";
        } catch (FileNotFoundException ex) {
            advertise = "Non è stato trovato il file";
        } catch (ClassNotFoundException ex) {
            advertise = "Il caricamento non è andato a buon fine";
        } catch (IOException ex) {
            advertise = "Il caricamento non è andato a buon fine";
        }
        return advertise;
    }
    
    public String visualizzaTutto(){
        return "Tutte le operazioni che sono state eseguite sono\n" + toString();
    }

    @Override
    public String toString() {
        String s = "";
        for (Operazione a : operazioni) {
            s += a.toString();
        }
        return s;
    }

}
