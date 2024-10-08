package appli.accueil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class AcceuilView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AjouterListe;

    @FXML
    private TableView<?> colonne;

    @FXML
    private Button deconnexion;

    @FXML
    private Button types;

    @FXML
    void OnActionAjoutListe(ActionEvent event) {

    }

    @FXML
    void OnActionDeconnexion(ActionEvent event) {

    }

    @FXML
    void OnActionTypes(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AjouterListe != null : "fx:id=\"AjouterListe\" was not injected: check your FXML file 'acceuilView.fxml'.";
        assert colonne != null : "fx:id=\"colonne\" was not injected: check your FXML file 'acceuilView.fxml'.";
        assert deconnexion != null : "fx:id=\"deconnexion\" was not injected: check your FXML file 'acceuilView.fxml'.";
        assert types != null : "fx:id=\"types\" was not injected: check your FXML file 'acceuilView.fxml'.";

    }

}
