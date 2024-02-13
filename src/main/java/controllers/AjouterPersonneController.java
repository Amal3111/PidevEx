package controllers;

import entities.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.PersonneService;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterPersonneController {

    @FXML
    private TextField ageTf;

    @FXML
    private TextField nomTf;

    @FXML
    private TextField prenomTf;
    private final PersonneService personneService=new PersonneService();
    @FXML
    void naviger(ActionEvent event) {

        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/AfficherPersonne.fxml"));
            Parent root = loader.load();
            prenomTf.getScene().setRoot(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void ajouterPers(ActionEvent event) {
        try {
            personneService.ajouter(new Personne(Integer.parseInt(ageTf.getText()),nomTf.getText(),prenomTf.getText()));
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes!");
            alert.setContentText("personne ajouté!");
        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
