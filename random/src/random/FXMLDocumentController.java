/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import generazioni.NumeriRandomici;
import java.util.LinkedList;

/**
 *
 * @author feder
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private TextField startTxt;
    @FXML
    private TextField endTxt;
    @FXML
    private Label risultato;
    
    private LinkedList <String> tipiNumero = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipiNumero.add("Intero");
        tipiNumero.add("Negativo");
        tipiNumero.add("Decimale");
        tipiNumero.add("Decimale negativo");
    }

    @FXML
    private void Genera(ActionEvent event) {
        int start = Integer.parseInt(startTxt.getText());
        int end = Integer.parseInt(endTxt.getText());
        int generato = NumeriRandomici.GeneraInt(start, end);
        if (generato != -1) {
            risultato.setText("Numeri: " + generato);
        } else{
            risultato.setText("Errore nell'inserimento delle informazioni");
        }
    }

}
