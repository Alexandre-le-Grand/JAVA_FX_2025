package appli.accueil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import appli.Database.Database;
import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AcceuilView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AjouterListe;

    @FXML
    private TableView<Liste> colonne;

    @FXML
    private TableColumn<Liste, Integer> idColumn;

    @FXML
    private TableColumn<Liste, String> nomColumn;

    @FXML
    private TableColumn<Liste, LocalDateTime> dateColumn;

    @FXML
    private Button deconnexion;

    @FXML
    private Button types;

    private ObservableList<Liste> listeObservableList;

    @FXML
    void OnActionAjoutListe(ActionEvent event) {
        StartApplication.changeScene("ajoutListesView", "Login");
    }

    @FXML
    void OnActionDeconnexion(ActionEvent event) {
        StartApplication.changeScene("loginView", "Login");
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

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idListe"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));

        chargerListe();
    }

    private void chargerListe() {
        listeObservableList = FXCollections.observableArrayList();

        Database db = new Database();
        Connection connection = db.getConnexion();

        String query = "SELECT id_liste, nom, date_creation FROM listes";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_liste");
                String nom = resultSet.getString("nom");
                LocalDateTime dateCreation = resultSet.getTimestamp("date_creation").toLocalDateTime();

                listeObservableList.add(new Liste(id, nom, dateCreation));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        colonne.setItems(listeObservableList);
    }
}
