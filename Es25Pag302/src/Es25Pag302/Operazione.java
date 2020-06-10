/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Es25Pag302;

import java.io.Serializable;

/**
 *
 * @author feder
 */
public class Operazione implements Serializable {

    protected static int codiceSequenziale = 1;
    private int codiceOperazione;
    private double importo;
    private String motivazione;
    private String tipoOperazione;

    public Operazione(double importo, String motivazione, String tipo) {
        codiceOperazione = codiceSequenziale;
        codiceSequenziale++;
        this.importo = importo;
        this.motivazione = motivazione;
        tipoOperazione = tipo;
    }

    public static int getCodiceSequenziale() {
        return codiceSequenziale;
    }

    public int getCodiceOperazione() {
        return codiceOperazione;
    }

    public double getImporto() {
        return importo;
    }

    public String getMotivazione() {
        return motivazione;
    }
    

    public String toString() {
        return "Codice: " + codiceOperazione + " " + tipoOperazione + ": " + importo + " motivo: " + motivazione + "\n";
    }

}
