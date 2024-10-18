package appli.accueil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import appli.Database.Database;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AjoutListesController {

    @FXML
    private TextField nomListeField;

    @FXML
    public void ajouterListe() {
        String nomListe = nomListeField.getText().trim();

        if (nomListe.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Nom de la liste manquant");
            alert.setContentText("Veuillez entrer un nom pour la liste.");
            alert.showAndWait();
        } else {
            LocalDateTime dateCreation = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateCreation.format(formatter);

            System.out.println("Liste ajoutée : " + nomListe + " à la date : " + formattedDate);

            String query = "INSERT INTO listes (nom, date_creation) VALUES (?, ?)";
            try (Connection connection = new Database().getConnexion();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nomListe);
                preparedStatement.setString(2, formattedDate);
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    System.out.println("Liste ajoutée avec succès.");
                } else {
                    System.out.println("Erreur lors de l'ajout de la liste.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Liste ajoutée");
            alert.setContentText("La liste '" + nomListe + "' a été ajoutée avec succès à la date : " + formattedDate);
            alert.showAndWait();

            nomListeField.clear();
        }
    }

    public void retour(ActionEvent actionEvent) {
        StartApplication.changeScene("acceuilView", "Accueil");
    }
}

