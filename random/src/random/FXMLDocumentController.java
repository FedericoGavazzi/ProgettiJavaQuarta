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
import generazioni.GenerazioneRandomica;
import java.util.LinkedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author feder
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button backBtn;

//componenti schermata Home
    @FXML
    private Label firstChoiseLbl;
    @FXML
    private ComboBox<String> genChoiseBox;
    @FXML
    private Label mainTitleLbl;

//componenti schermata generatore di numeri
    @FXML
    private TextField startTxt;
    @FXML
    private TextField endTxt;
    @FXML
    private Label risultato;
    @FXML
    private ComboBox<String> sceltaNumero;
    @FXML
    private Button generaBtn;
    @FXML
    private Label numberTitleLbl;

//componenti generatore di testo
    @FXML
    private Label textTitleLbl;
    @FXML
    private TextField paragTxt;
    @FXML
    private TextField wordsTxt;
    @FXML
    private Label paragLbl;
    @FXML
    private Label wordsLbl;
    @FXML
    private ScrollPane textScrollPane;
    @FXML
    private Label generatedTextLbl;
    @FXML
    private Button generateTextBtn;

//liste per comboBox
    private LinkedList<String> tipiNumero = new LinkedList<>();
    private LinkedList<String> generatorChoise = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipiNumero.add("Interi");
        tipiNumero.add("Decimali");
        sceltaNumero.getItems().addAll(tipiNumero);
        generatorChoise.add("Numeri");
        generatorChoise.add("Testo");
        genChoiseBox.getItems().addAll(generatorChoise);
    }

    @FXML
    private void Visualize(ActionEvent event) {
        if (genChoiseBox.getValue().equals(generatorChoise.get(0))) {
            startTxt.setVisible(true);
            endTxt.setVisible(true);
            risultato.setVisible(true);
            sceltaNumero.setVisible(true);
            generaBtn.setVisible(true);
            numberTitleLbl.setVisible(true);

            firstChoiseLbl.setVisible(false);
            genChoiseBox.setVisible(false);
            mainTitleLbl.setVisible(false);
        } else if (genChoiseBox.getValue().equals(generatorChoise.get(1))) {
            textTitleLbl.setVisible(true);
            paragTxt.setVisible(true);
            wordsTxt.setVisible(true);
            paragLbl.setVisible(true);
            wordsLbl.setVisible(true);
            textScrollPane.setVisible(true);
            generatedTextLbl.setVisible(true);
            generateTextBtn.setVisible(true);

            firstChoiseLbl.setVisible(false);
            genChoiseBox.setVisible(false);
            mainTitleLbl.setVisible(false);
        }
    }

    @FXML
    private void Back(ActionEvent event) {
        //componenti generatore di numeri
        startTxt.setVisible(false);
        endTxt.setVisible(false);
        risultato.setVisible(false);
        sceltaNumero.setVisible(false);
        generaBtn.setVisible(false);
        numberTitleLbl.setVisible(false);

        //componenti generatore di testo
        textTitleLbl.setVisible(false);
        paragTxt.setVisible(false);
        wordsTxt.setVisible(false);
        paragLbl.setVisible(false);
        wordsLbl.setVisible(false);
        textScrollPane.setVisible(false);
        generatedTextLbl.setVisible(false);
        generateTextBtn.setVisible(false);

        //compnenti home
        firstChoiseLbl.setVisible(true);
        genChoiseBox.setVisible(true);
        mainTitleLbl.setVisible(true);
    }

    @FXML
    private void GenerateNumber(ActionEvent event) {
        double start = Double.parseDouble(startTxt.getText());
        double end = Double.parseDouble(endTxt.getText());
        if (sceltaNumero.getValue().equals(tipiNumero.get(0))) {
            risultato.setText("Numeri: " + GenerazioneRandomica.GeneraInteri(start, end));
        } else if (sceltaNumero.getValue().equals(tipiNumero.get(1))) {
            risultato.setText("Numeri: " + GenerazioneRandomica.GeneraDecimali(start, end));
        }
    }

    @FXML
    private void GenerateText(ActionEvent event) {
        int nParag = Integer.parseInt(paragTxt.getText());
        int nWords = Integer.parseInt(wordsTxt.getText());
        generatedTextLbl.setText(GenerazioneRandomica.GeneratoreTesto(nParag, nWords));
    }

}
