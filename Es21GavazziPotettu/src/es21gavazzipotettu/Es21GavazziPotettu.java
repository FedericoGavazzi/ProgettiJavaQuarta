/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es21gavazzipotettu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Gavazzi & Potettu
 */
public class Es21GavazziPotettu {

    static String getScritta() {
        Scanner s = new Scanner(System.in);
        String scritta = s.nextLine();
        return scritta;
    }

    static boolean menu(int azione) throws IOException {
        //qua ci sarà il menù da chiamare nel main e si userà uno switch
        Scanner input = new Scanner(System.in);
        int scelta;
        switch (azione) {

            case 1:
                do {
                    System.out.println("1. Aggiungi un libro\n2. Cerca un libro\n0. Indietro");
                    scelta = input.nextInt();
                    switch (scelta) {
                        case 1:
                            System.out.println("Inserisci il codice ISBN");
                            String ISBN = getScritta();
                            System.out.println("Inserisici il titolo");
                            String titolo = getScritta();
                            System.out.println("Inserisci l'autore");
                            String autore = getScritta();
                            System.out.println("Inserisci la casa editrice");
                            String casaEditrice = getScritta();
                            System.out.println("Inserisci l'anno di pubblicazione");
                            int annoPubblicazione = input.nextInt();
                            System.out.println(aggiungiLibro(ISBN, titolo, autore, casaEditrice, annoPubblicazione));
                            break;
                        case 2:
                            System.out.println("Inserisci il codice ISBN del libro che vuoi trovare");
                            ISBN = getScritta();
                            System.out.println(cercaLibro(ISBN));
                            break;
                    }
                } while (scelta != 0);
                break;
            case 2:
                do {
                    System.out.println("1. Aggiungi un socio\n2. Cerca un socio\n0. Indietro");
                    scelta = input.nextInt();
                    switch (scelta) {
                        case 1:
                            System.out.println("Inserisci il nome");
                            String nome = getScritta();
                            System.out.println("Inserisci il cognome");
                            String cognome = getScritta();
                            System.out.println("Inserisci il codice fiscale");
                            String codiceFiscale = getScritta();
                            System.out.println(aggiungiSocio(codiceFiscale, nome, cognome));
                            break;
                        case 2:
                            System.out.println("Inserisci il codice fiscale");
                            codiceFiscale = getScritta();
                            System.out.println(cercaSocio(codiceFiscale));
                            break;
                    }
                } while (scelta != 0);
                break;
            case 3:
                do {
                    System.out.println("1. Aggiungi un prestito\n2. Aggiungi un prestito e un nuovo socio\n3. Cerca prestito\n4. Rimuovi prestito\n0. Indietro");
                    scelta = input.nextInt();
                    switch (scelta) {
                        case 1:
                            System.out.println("Inserisci il codice ISBN del libro");
                            String ISBN = getScritta();
                            System.out.println("Inserisci il codice fiscale del socio");
                            String codiceFiscale = getScritta();
                            System.out.println(nuovoPrestito(ISBN, codiceFiscale));
                            break;
                        case 2:
                            System.out.println("Inserisci il codice ISBN del libro");
                            ISBN = getScritta();
                            System.out.println("Inserisci il nome del nuovo socio");
                            String nome = getScritta();
                            System.out.println("Inserisci il cognome del nuovo socio");
                            String cognome = getScritta();
                            System.out.println("Inserisci il codice fiscale del nuovo socio");
                            codiceFiscale = getScritta();
                            System.out.println(nuovoPrestitoNuovoSocio(ISBN, codiceFiscale, nome, cognome));
                            break;
                        case 3:
                            System.out.println("Inserisci il codice fiscale del socio");
                            codiceFiscale = getScritta();
                            System.out.println(cercaPrestito(codiceFiscale));
                            break;
                        case 4:
                            System.out.println("Inserisci il codice fiscale del socio");
                            codiceFiscale = getScritta();
                            System.out.println(rimuoviPrestito(codiceFiscale));
                            break;
                    }
                } while (scelta != 0);
                break;
            case 4:
                System.out.println(salvataggioDati());
                break;
            case 5:
                System.out.println("Libri:\n" + libri + "Soci:1n" + soci + "Prestiti:\n" + prestiti);
                break;
            case 0:
                System.out.println(salvataggioDati() + " in automatico");
                return false;
        }
        return true;
    } //per ora funziona tutto ma non ho fatto molti test
    //sarà necessario eseguire un po' di prove per verificare il corretto funzionamento del programma

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int azione;
        for(int i = 0; i < 10; i++){
            AggiungiLibroRandom();
            AggiungiSocioRandom();
        }
        System.out.println(caricaDati());
        do {
            System.out.println("Cosa vuoi fare?\n1. Gestire i libri\n2. Gestire i soci\n3. Gestire i prestiti\n4. Salvare\n5. Visualizzare tutte le informazioni\n0. Chiudere il programma");
            azione = scan.nextInt();
        } while (menu(azione));
    }

    static TreeMap<String, Socio> soci = new TreeMap<>();
    static HashMap<String, Libro> libri = new HashMap<>();
    static ArrayList<Prestito> prestiti = new ArrayList<>();

    static void AggiungiLibroRandom() {
        Libro nuovo = new Libro();
        libri.put(nuovo.getISBN(), nuovo);
    }

    static void AggiungiSocioRandom() {
        Socio nuovo = new Socio();
        soci.put(nuovo.getCodiceFiscale(), nuovo);
    }

    //viene aggiunto un nuovo libro questa è una cosa in +
    static String aggiungiLibro(String ISBN, String titolo, String autore, String casaEditrice, int annoPubblicazione) {
        if (ISBN.equals("") || titolo.equals("") || autore.equals("") || casaEditrice.equals("")) {
            return "Non è stato aggiunto il libro. Informazioni insufficienti.";
        }
        if (ISBN.length() != 13) {
            return "Il codice inserito non è valido.";
        }
        Libro cercato = libri.get(ISBN);
        if (cercato != null) {
            return "Il libro esiste già.";

        }
        Libro nuovo = new Libro(ISBN, titolo, autore, casaEditrice, annoPubblicazione);
        libri.put(nuovo.getISBN(), nuovo);
        return "È stato aggiunto il libro.";
    }

    //viene cercato un libro tramite il suo codice
    static String cercaLibro(String ISBN) {
        if (ISBN.length() != 13) {
            return "Il codice inserito non è valido.";
        }
        Libro trovato = libri.get(ISBN);
        if (trovato == null) {
            return "Non è stato trovato il libro.";
        }
        return trovato.toString();
    }

    //aggiungo un nuovo socio
    static String aggiungiSocio(String codiceFiscale, String nome, String cognome) {
        if (codiceFiscale.equals("") || nome.equals("") || cognome.equals("")) {
            return "Non è stato aggiunto il socio. Informazioni insufficienti.";
        }
        if (codiceFiscale.length() != 16) {
            return "Codice fiscale non valido.";
        }
        Socio cercato = soci.get(codiceFiscale);
        if (cercato != null) {
            return "Il socio esiste già.";
        }
        Socio nuovo = new Socio(codiceFiscale, nome, cognome);
        soci.put(nuovo.getCodiceFiscale(), nuovo);
        return "È stato aggiunto il socio.";
    }

    //aggiungo un nuovo socio
    static boolean aggiungiSocioBool(String codiceFiscale, String nome, String cognome) {
        if (codiceFiscale.equals("") || nome.equals("") || cognome.equals("")) {
            return false;
        }
        if (codiceFiscale.length() != 16) {
            return false;
        }
        Socio nuovo = new Socio(codiceFiscale, nome, cognome);
        soci.put(nuovo.getCodiceFiscale(), nuovo);
        return true;
    }

    //viene cercato un socio tramite il codice fiscale
    static String cercaSocio(String codiceFiscale) {
        if (codiceFiscale.length() != 16) {
            return "Codice fiscale non valido.";
        }
        Socio trovato = soci.get(codiceFiscale);
        if (trovato == null) {
            return "Non è stato trovato il socio.";
        }
        return trovato.toString();
    }

    static Socio cercaSoci(String codiceFiscale) {
        if (codiceFiscale.length() != 16) {
            return null;
        }
        Socio trovato = soci.get(codiceFiscale);
        if (trovato == null) {
            return null;
        }
        return trovato;
    }

    static boolean controllaSocio(String codiceFiscale) {
        if (codiceFiscale.length() != 16) {
            return false;
        }
        Socio trovato = soci.get(codiceFiscale);
        if (trovato == null) {
            return false;
        }
        return true;
    }

    //aggiunta di un nuovo prestito
    static String nuovoPrestito(String ISBN, String codiceFiscale) {
        //viene aggiunto un nuovo prestito cercando le informazioni nelle liste 
        if (codiceFiscale.length() != 16) {
            return "Codice fiscale non valido";
        }
        if (ISBN.length() != 13) {
            return "Il codice ISBN inserito non è valido.";
        }
        Prestito nuovo = new Prestito(libri.get(ISBN), soci.get(codiceFiscale));
        prestiti.add(nuovo);
        return "Operazione riuscita.\n" + nuovo.toString();
    }

    //nuovo prestito con aggiunta di un nuovo socio
    static String nuovoPrestitoNuovoSocio(String ISBN, String codiceFiscale, String nome, String cognome) {
        if (!aggiungiSocioBool(codiceFiscale, nome, cognome)) {
            return "Informazioni mancanti o errate. Riprovare.";
        }
        nuovoPrestito(ISBN, codiceFiscale);
        return "Tutte le informazioni sono state aggiunte correttamente";
    }

    //rimozione di un prestito
    static String rimuoviPrestito(String codiceFiscale) {
        //viene eliminato il prestito cercando con il codice del socio 
        if (codiceFiscale.length() != 16) {
            return "Codice fiscale non valido";
        }
        Socio cercato = soci.get(codiceFiscale);
        if(cercato == null){
            return "Il socio cercato non è registrato";
        }
        for (Prestito p : prestiti) {
            if (p.getSocio().equals(cercato)) {
                prestiti.remove(p);
                return p + "Operazione riuscita.\n" + cercaSocio(codiceFiscale) + " ha restituito il libro.";
            }
        }
        return "Nessun prestito era in corso per " + cercaSocio(codiceFiscale);
    }

    //ricerca di un prestito tramite il socio
    static String cercaPrestito(String codiceFiscale) {
        if (codiceFiscale.length() != 16) {
            return "Codice fiscale non valido.";
        }
        Socio cercato = cercaSoci(codiceFiscale);
        for (Prestito p : prestiti) {
            if (p.getSocio().equals(cercato)) {
                return p.toString();
            }
        }
        return "Nessun prestito è intestato a questo socio.";
    }

    //vengono caricati i dati dai 3 file delle liste
    //i file saranno Libri.bin, Soci.bin, Prestiti.bin
    static String caricaDati() {
        String advertise;
        try {
            ObjectInputStream inLibri = new ObjectInputStream(new FileInputStream("Libri.bin"));
            ObjectInputStream inSoci = new ObjectInputStream(new FileInputStream("Soci.bin"));
            ObjectInputStream inPrestiti = new ObjectInputStream(new FileInputStream("Prestiti.bin"));

            libri = (HashMap<String, Libro>) inLibri.readObject();
            soci = (TreeMap<String, Socio>) inSoci.readObject();
            prestiti = (ArrayList<Prestito>) inPrestiti.readObject();
            advertise = "I dati sono stati caricati con successo dal file";
        } catch (FileNotFoundException ex) {
            advertise = "Non è stato trovato il file";
        } catch (ClassNotFoundException | IOException ex) {
            advertise = "Il caricamento non è andato a buon fine";
        }
        return advertise;
    }

    //vengono salvati i file nei 3 file
    static String salvataggioDati() throws FileNotFoundException, IOException {
        ObjectOutputStream outLibri = new ObjectOutputStream(new FileOutputStream("Libri.bin"));
        ObjectOutputStream outSoci = new ObjectOutputStream(new FileOutputStream("Soci.bin"));
        ObjectOutputStream outPrestiti = new ObjectOutputStream(new FileOutputStream("Prestiti.bin"));
        outLibri.writeObject(libri);
        outSoci.writeObject(soci);
        outPrestiti.writeObject(prestiti);
        return "Salvataggio effettuato nel file";
    }

    static String visualizzaTutto() {
        String s = "Libri:\n";
        Collection<Libro> Libri = libri.values();
        for (Libro lb : Libri) {
            s += lb.toString();
        }
        s += "\nSoci:\n";
        Collection<Socio> Soci = soci.values();
        for (Socio sc : Soci) {
            s += sc.toString();
        }
        s += "\nPrestiti:\n";
        for (Prestito pr : prestiti) {
            s += pr.toString();
        }
        return s;
    }

}
