package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        // Load the initial login view
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        mainStage.setTitle("Bonjour");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String fxml, String nomScene) {
        try {
            // Load the new FXML scene
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/" + fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            mainStage.setTitle(nomScene);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
