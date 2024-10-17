package appli.accueil;

import appli.StartApplication;
import appli.Database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Button connexion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMdp;

    // Called when the Connexion button is clicked
    @FXML
    private void OnActionConnexion() {
        String email = txtEmail.getText();
        String mdp = txtMdp.getText();

        if (verifierUtilisateur(email, mdp)) {
            StartApplication.changeScene("acceuilView", "Acceuil");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Connexion");
            alert.setHeaderText("Email ou mot de passe incorrect");
            alert.setContentText("Veuillez vérifier vos informations et réessayer.");
            alert.showAndWait();
        }
    }

    @FXML
    private void OnActionMdpOublie() {
        System.out.println("Mot de passe oublié");
    }

    @FXML
    private void OnActionInscription() {
        StartApplication.changeScene("InscriptionView", "Inscription");
    }

    private boolean verifierUtilisateur(String email, String mdp) {
        Database database = new Database();
        Connection connection = database.getConnexion();

        if (connection != null) {
            String query = "SELECT * FROM utilisateur WHERE email = ? AND mdp = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, mdp);
                ResultSet rep = preparedStatement.executeQuery();

                if (rep.next()) {
                    return true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
