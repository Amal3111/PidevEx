package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
//Stage heya el fenetre el kbira eli feha titre wel body howa el scene
    //ken navigation on va garder le meme stage mais ecraser le contenu (scene)
    @Override
    public void start(Stage primarystage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/AjouterPersonne.fxml"));
        Parent root=loader.load();//ou //AnchorPane root=loader.load();
        Scene scene= new Scene(root);
        primarystage.setScene(scene);
        primarystage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
