package controllers;

import entities.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.PersonneService;

import java.sql.SQLException;
import java.util.List;

public class AfficherPersonneController {

    @FXML
    private TableColumn<Personne,Integer> columnAgePers;

    @FXML
    private TableColumn<Personne, String> columnNomPers;

    @FXML
    private TableColumn<Personne, String> columnPrenomPers;

    @FXML
    private TableView<Personne> tableViewPers;
    private final PersonneService personneService=new PersonneService();

    @FXML
    void initialize() {
        try {
            List<Personne> personnes=personneService.recuperer();
            ObservableList<Personne> observableList = FXCollections.observableList(personnes);
            tableViewPers.setItems(observableList);
            columnNomPers.setCellValueFactory(new PropertyValueFactory<>("nom"));
            columnPrenomPers.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            columnAgePers.setCellValueFactory(new PropertyValueFactory<>("age"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
