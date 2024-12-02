package com.github.juan.view;

import com.github.juan.Model.dao.GarageDAO;
import com.github.juan.Model.entity.Garage;
import com.github.juan.App;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GarageConfigController extends Controller implements Initializable {
    @FXML
    Button crear;
    @FXML
    ImageView volver;
    @FXML
    TableView<Garage> table;
    @FXML
    TableColumn<Garage, Integer> Id;
    @FXML
    TableColumn<Garage, String> location;
    @FXML
    TableColumn<Garage, String> capacity;
    @FXML
    Button eliminar;
    @FXML
    Button anadir;


    private ObservableList<Garage> garages;

    @Override
    public void onOpen(Object input) throws IOException {
        GarageDAO gDAO = new GarageDAO();
        List<Garage> garages = gDAO.findAll();
        this.garages = FXCollections.observableArrayList(garages);
        table.setItems(this.garages);
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GarageDAO gDAO = new GarageDAO();
        table.setEditable(true);
        table.setRowFactory(tv -> {
            TableRow<Garage> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Garage garage = table.getSelectionModel().getSelectedItem();
                if (event.getClickCount() == 3 && ! row.isEmpty() && garage != null ) {
                    Garage garage1 = row.getItem();
                    try {
                        App.currentController.changeScene(Scenes.ADDSCARSINGARAGE, garage1.getId());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            return row ;
        });
        Id.setCellValueFactory(garage -> new SimpleIntegerProperty(garage.getValue().getId()).asObject());
        location.setCellValueFactory(garage -> new SimpleStringProperty(garage.getValue().getLocation()));
        location.setCellFactory(TextFieldTableCell.forTableColumn());
        capacity.setCellFactory(TextFieldTableCell.forTableColumn());
        location.setOnEditCommit(event -> {
            if (event.getNewValue().equals(event.getOldValue())) {
                return;
            }
            Garage garage = event.getRowValue();
            garage.setLocation(event.getNewValue());
            gDAO.update(garage);
        });
    }

    public void changeSceneToMainPage() throws IOException{
        App.currentController.changeScene(Scenes.MAIN,null);
    }
    public void changeSceneToCreateGarage() throws IOException{
        App.currentController.changeScene(Scenes.CREATEGARAGE,null);
    }
    public void changeSceneToAddCarsGarage() throws IOException{
        App.currentController.changeScene(Scenes.ADDSCARSINGARAGE,null);
    }
    public void changeSceneToDeleteGarage() throws IOException{
        App.currentController.changeScene(Scenes.DELETEGARAGE,null);
    }
}
