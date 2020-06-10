/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Es25Pag302;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Gavazzi & Potettu
 */
public class Es25Pag32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        AttivitaEconomiche listaAttivita = new AttivitaEconomiche();
        Scanner scan = new Scanner(System.in);
        double importo;
        int codice;
        String op, motivazione, azione;
        boolean exit = true;
        System.out.println(listaAttivita.Carica());

        do {
            System.out.println("Cosa vuoi fare? Inserire, eliminare, visualizzare, salvare, caricare.\nDigitare esci per uscire dal programma.");
            azione = scan.next();

            if (azione.equalsIgnoreCase("esci")) {
                exit = false;
            } else if (azione.equalsIgnoreCase("inserire")) {
                System.out.println("Che tipo di operazione vuoi aggiungere: Incasso o Spesa?");
                op = scan.next();
                System.out.println("Inserisci l'importo");
                importo = scan.nextDouble();
                System.out.println("Inserisci la motivazione");
                motivazione = scan.next();
                motivazione += scan.nextLine();
                if (op.equalsIgnoreCase("incasso")) {
                    listaAttivita.nuovoIncasso(importo, motivazione);
                } else if (op.equalsIgnoreCase("spesa")) {
                    listaAttivita.nuovaSpesa(importo * (-1), motivazione);
                }
            } else if (azione.equalsIgnoreCase("eliminare")) {
                System.out.println("Inserisci il codice dell'operazione");
                System.out.println(listaAttivita.elimina(scan.nextInt()));
            } else if (azione.equalsIgnoreCase("visualizzare")) {
                System.out.println("cosa vuoi visualizzare? Tutte le operazioni o una sola operazione. (T/U)");
                op = scan.next();
                if (op.equalsIgnoreCase("t")) {
                    System.out.println(listaAttivita.visualizzaTutto());
                } else if (op.equalsIgnoreCase("u")) {
                    System.out.println("Scegli in che modo trovare la tua operazione codice oppure descrizione. (C/D)");
                    op = scan.next();
                    if (op.equalsIgnoreCase("c")) {
                        System.out.println("Inserisci il codice");
                        codice = scan.nextInt();
                        System.out.println(listaAttivita.visualizza(codice));

                    } else if (op.equalsIgnoreCase("d")) {
                        System.out.println("Inserisci l'importo (se si tratta di una spesa inserire l'importo negativo) e inserisci la motivazione");
                        importo = scan.nextDouble();
                        motivazione = scan.next();
                        motivazione += scan.nextLine();
                        System.out.println(listaAttivita.visualizza(importo, motivazione));
                    }
                }
            } else if (azione.equalsIgnoreCase("caricare")) {
                System.out.println(listaAttivita.Carica());
            } else if (azione.equalsIgnoreCase("salvare")) {
                System.out.println(listaAttivita.Salva());
            }
        } while (exit);

    }
}
