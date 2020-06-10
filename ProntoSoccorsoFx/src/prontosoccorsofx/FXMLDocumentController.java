/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prontosoccorsofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 77785190
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button add_paz;
    @FXML
    private Label adv_lbl;
    @FXML
    private TextField nome_txt;
    @FXML
    private TextField cog_txt;
    @FXML
    private TextField cod_txt;
    @FXML
    private AnchorPane grav_cb;
    private TextField grav_txt;
    @FXML
    private Label numPaz;
    @FXML
    private RadioButton rb_bianco;
    @FXML
    private RadioButton rb_verde;
    @FXML
    private RadioButton rb_giallo;
    @FXML
    private RadioButton rb_rosso;
    @FXML
    private Label gravita_lbl;
    @FXML
    private Label successivo;
    private Coda rosso;
    private Coda giallo;
    private Coda verde;
    private Coda bianco;
    private int n_pazienti;
    private Paziente listaRossa[] = new Paziente[5000];
    private Paziente listaGialla[] = new Paziente[5000];
    private Paziente listaVerde[] = new Paziente[5000];
    private Paziente listaBianca[] = new Paziente[5000];
    private int n_rosso;
    private int n_giallo;
    private int n_verde;
    private int n_bianco;
    @FXML
    private Label listaCompletaNome;
    @FXML
    private Label listaCompletaCodice;
    @FXML
    private Label listaCompletaCognome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rosso = new Coda();
        giallo = new Coda();
        verde = new Coda();
        bianco = new Coda();
        n_pazienti = 0;
        adv_lbl.setText("");
        numPaz.setText("Rimangono ancora 0 pazienti");
        successivo.setText("");
        listaCompletaNome.setText("          Nome");
        listaCompletaCognome.setText("Cognome");
        listaCompletaCodice.setText("Codice");
    }

    @FXML
    private void aggiungiPaziente(ActionEvent event) {
        //controllo che venga selezionata solo una coda per volta
        if ((rb_bianco.isSelected() && rb_verde.isSelected() && rb_giallo.isSelected() && rb_rosso.isSelected())
                || (rb_bianco.isSelected() && rb_verde.isSelected()) || (rb_bianco.isSelected() && rb_giallo.isSelected())
                || (rb_bianco.isSelected() && rb_rosso.isSelected()) || (rb_verde.isSelected() && rb_giallo.isSelected())
                || (rb_verde.isSelected() && rb_rosso.isSelected()) || (rb_giallo.isSelected() && rb_rosso.isSelected())) {
            adv_lbl.setText("Seleziona un solo grado di gravità.");
        } //controllo che tutti i campi siano compilati e in caso contrario avviso che non è stato aggiunto il paziente e in caso siano completi
        //controllo quale pulsante è acceso e aggiungo l'elemento alla coda
        else if (nome_txt.getText().equals("") && cog_txt.getText().equals("") && cod_txt.getText().equals("")) {
            adv_lbl.setText("Qualcosa è andato storto. Non è stato aggiunto il paziente.");
        } else {
            if (rb_bianco.isSelected()) {
                n_pazienti++;
                bianco.Push(new Paziente(cod_txt.getText(), nome_txt.getText(), cog_txt.getText(), n_pazienti));
                adv_lbl.setText("È stato aggiunto il paziente nella coda di codice bianco.");

                if (n_pazienti == 1) {
                    successivo.setText("Il paziente successivo è " + cog_txt.getText() + " " + nome_txt.getText() + "\ncon codice bianco.");
                }

            } else if (rb_verde.isSelected()) {
                n_pazienti++;
                verde.Push(new Paziente(cod_txt.getText(), nome_txt.getText(), cog_txt.getText(), n_pazienti));
                adv_lbl.setText("È stato aggiunto il paziente nella coda di codice verde.");

                if (n_pazienti == 1) {
                    successivo.setText("Il paziente successivo è " + cog_txt.getText() + " " + nome_txt.getText() + "\ncon codice verde.");
                }

            } else if (rb_giallo.isSelected()) {
                n_pazienti++;
                giallo.Push(new Paziente(cod_txt.getText(), nome_txt.getText(), cog_txt.getText(), n_pazienti));
                adv_lbl.setText("È stato aggiunto il paziente nella coda di codice giallo.");

                if (n_pazienti == 1) {
                    successivo.setText("Il paziente successivo è " + cog_txt.getText() + " " + nome_txt.getText() + "\ncon codice giallo.");
                }

            } else if (rb_rosso.isSelected()) {
                n_pazienti++;
                rosso.Push(new Paziente(cod_txt.getText(), nome_txt.getText(), cog_txt.getText(), n_pazienti));
                adv_lbl.setText("È stato aggiunto il paziente nella coda di codice rosso.");

                if (n_pazienti == 1) {
                    successivo.setText("Il paziente successivo è " + cog_txt.getText() + " " + nome_txt.getText() + "\ncon codice rosso.");
                }
            } else {
                adv_lbl.setText("Qualcosa è andato storto. Non è stato aggiunto il paziente.");
            }
        }
        //non faccio andare in negativo il counter

        if (n_pazienti < 0) {
            n_pazienti = 0;
        }
        // dice quanti pazienti rimangono
        numPaz.setText("Ci sono ancora " + n_pazienti + " pazienti in sala d'attesa.");
        //controllo la priorità del paziente che aggiungo quando ho salvato più di un elemento e in caso la priorità del nuovo sia maggiore
        //di quella dell'elemento già salvato aggiorno la label informativa sul paziente successivo
        if (n_pazienti > 1) {
            if (rosso.isEmpty() == false) {
                successivo.setText("Il paziente successivo è " + rosso.getPrimoPaziente() + " con codice rosso.");
            } else if (giallo.isEmpty() == false) {
                successivo.setText("Il paziente successivo è " + giallo.getPrimoPaziente() + "con codice giallo.");
            } else if (verde.isEmpty() == false) {
                successivo.setText("Il paziente successivo è " + verde.getPrimoPaziente() + " con codice verde.");
            } else if (bianco.isEmpty() == false) {
                successivo.setText("Il paziente successivo è " + bianco.getPrimoPaziente() + " con codice bianco.");
            }
        }

        //pulisco i text field
        nome_txt.clear();
        cog_txt.clear();
        cod_txt.clear();

        //lista completa dei pazienti
        String sNome = "          Nome\n" + rosso.listaNomi("Rosso") + giallo.listaNomi("Giallo") + verde.listaNomi("Verde") + bianco.listaNomi("Bianco");
        String sCognome = "Cognome\n" + rosso.listaCognomi() + giallo.listaCognomi() + verde.listaCognomi() + bianco.listaCognomi();
        String sCodice = "Codice sanitario\n" + rosso.listaCodici() + giallo.listaCodici() + verde.listaCodici() + bianco.listaCodici();
        listaCompletaNome.setText(sNome);
        listaCompletaCognome.setText(sCognome);
        listaCompletaCodice.setText(sCodice);
    }

    @FXML
    private void TogliPaziente(ActionEvent event) {
        Nodo temp;
        if (rosso.isEmpty() && giallo.isEmpty() && verde.isEmpty() && bianco.isEmpty()) {
            adv_lbl.setText("Non ci sono pazienti da visitare.");
            successivo.setText("");

        } else if (rosso.isEmpty() == false) {
            n_pazienti--;
            temp = rosso.Pop();
            adv_lbl.setText("Il " + temp.getInfo() + " è andato in ambulatorio\n Ci sono ancora " + rosso.Size() + " pazienti con codice rosso.");

            if (temp.getNext() != null) {
                successivo.setText("Il paziente successivo è " + temp.getNext().getInfo() + "con codice rosso.");
            } else if (giallo.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + giallo.getPrimoPaziente() + "dcon codice giallo.");
            } else if (verde.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + verde.getPrimoPaziente() + "con codice verde.");
            } else if (bianco.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + bianco.getPrimoPaziente() + "con codice bianco.");
            } else {
                successivo.setText("");
            }

        } else if (rosso.isEmpty() == true && giallo.isEmpty() == false) {
            n_pazienti--;
            temp = giallo.Pop();
            adv_lbl.setText("Il " + temp.getInfo() + " è andato in ambulatorio \n Ci sono ancora " + giallo.Size() + " pazienti con codice giallo.");
            if (temp.getNext() != null) {
                successivo.setText("Il paziente successivo è " + temp.getNext().getInfo() + "con codice giallo.");
            } else if (verde.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + verde.getPrimoPaziente() + "con codice verde.");
            } else if (bianco.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + bianco.getPrimoPaziente() + "con codice bianco.");
            } else {
                successivo.setText("");
            }

        } else if (rosso.isEmpty() == true && giallo.isEmpty() == true && verde.isEmpty() == false) {
            n_pazienti--;
            temp = verde.Pop();
            adv_lbl.setText("Il " + temp.getInfo() + " è andato in ambulatorio \n Ci sono ancora " + verde.Size() + " pazienti con codice verde.");
            if (temp.getNext() != null) {
                successivo.setText("Il paziente successivo è " + temp.getNext().getInfo() + "con codice verde.");
            } else if (bianco.getPrimoPaziente() != null) {
                successivo.setText("Il paziente successivo è " + bianco.getPrimoPaziente() + "con codice bianco.");
            } else {
                successivo.setText("");
            }

        } else if (rosso.isEmpty() == true && giallo.isEmpty() == true && verde.isEmpty() == true && bianco.isEmpty() == false) {
            n_pazienti--;
            temp = bianco.Pop();
            adv_lbl.setText("Il " + temp.getInfo() + " è andato in ambulatorio \n Ci sono ancora " + bianco.Size() + " pazienti con codice bianco.");
            if (temp.getNext() != null) {
                successivo.setText("Il paziente successivo è " + temp.getNext().getInfo() + "con codice bianco");
            } else {

            }
        }

        if (n_pazienti < 0) {
            n_pazienti = 0;
        }
        if (n_pazienti > 1) {
            numPaz.setText("Ci sono ancora " + n_pazienti + " pazienti in sala d'attesa.");
        } else if (n_pazienti == 1) {
            numPaz.setText("Rimane 1 solo paziente in sala d'attesa");
        } else {
            numPaz.setText("Sono stati visitati tutti i pazienti");
        }

        //lista completa dei pazienti
        String sNome = "          Nome\n" + rosso.listaNomi("Rosso") + giallo.listaNomi("Giallo") + verde.listaNomi("Verde") + bianco.listaNomi("Bianco");
        String sCognome = "Cognome\n" + rosso.listaCognomi() + giallo.listaCognomi() + verde.listaCognomi() + bianco.listaCognomi();
        String sCodice = "Codice sanitario\n" + rosso.listaCodici() + giallo.listaCodici() + verde.listaCodici() + bianco.listaCodici();
        listaCompletaNome.setText(sNome);
        listaCompletaCognome.setText(sCognome);
        listaCompletaCodice.setText(sCodice);
    }

}
