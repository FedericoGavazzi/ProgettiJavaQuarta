/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generazioni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feder
 */
public class GenerazioneRandomica {

    public static int GeneraInteri(double floor, double top) {
        if ((top < floor)) {
            return GeneraInteri(top, floor);
        }
        int risultato = (int) (Math.random() * top);
        if (risultato < floor) {
            return GeneraInteri(floor, top);
        }
        return risultato;
    }

    public static double GeneraDecimali(double floor, double top) {
        if ((top < floor)) {
            return GeneraDecimali(top, floor);
        }
        double risultato = (float) (Math.random() * top);
        risultato = Math.round(risultato * 100);
        risultato = risultato / 100;
        if (risultato < floor) {
            return GeneraDecimali(floor, top);
        }
        return risultato;
    }

    public static String GeneratoreTesto(int nParag, int nWords) {
        String testo = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("diario_di_un_naturalista_darwin_e_altri_testi.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerazioneRandomica.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s;
        List<String> lista;
        lista = new ArrayList<>();
        try {
            while ((s = reader.readLine()) != null) {
                lista.addAll(Arrays.asList(s.split(" ")));
            }
        } catch (IOException ex) {
            Logger.getLogger(GenerazioneRandomica.class.getName()).log(Level.SEVERE, null, ex);
        }

        HashMap<LinkedList<String>, ArrayList<String>> map = new HashMap<>();
        int i = 0;
        LinkedList<String> prefisso;
        prefisso = new LinkedList<>();
        prefisso.add("\n");
        prefisso.add("\n");
        while (i < lista.size()) {
            ArrayList<String> v = map.get(prefisso);
            if (v == null) {
                v = new ArrayList<>();
                map.put(prefisso, v);
            }
            v.add(lista.get(i));
            prefisso = new LinkedList<>(prefisso);
            prefisso.remove(0);
            prefisso.add(lista.get(i));
            i++;
        }
        prefisso = new LinkedList<>();
        prefisso.add("Il");
        prefisso.add("geco");
        System.out.println("Qua ci arrivo");
        for (int j = 0; i < nParag; j++) {
            for (i = 1; i < nWords; i++) {
                lista = map.get(prefisso);
                String parola = lista.get((int) (Math.random() * lista.size()));
                if (i % 10 == 0) {
                    testo += "\n";
                }
                testo += parola + " ";
                prefisso.remove(0);
                prefisso.add(parola);
            }
        }
        return testo;
    }
}
