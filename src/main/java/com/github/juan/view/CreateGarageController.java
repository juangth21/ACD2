package com.github.juan.view;

import com.github.juan.Model.Singleton.UserSession;
import com.github.juan.Model.dao.GarageDAO;
import com.github.juan.Model.entity.Garage;
import com.github.juan.Model.entity.User;
import com.github.juan.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateGarageController extends Controller implements Initializable {

    @FXML
    TextField location;
    @FXML
    TextField capacity;
    @FXML
    Button crear;

    @Override
    public void onOpen(Object input) throws IOException {
        if (input instanceof User) {
            UserSession.login((User) input);
        }
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public Garage getGarageValues() {
        User currentUser = UserSession.getCurrentUser();
        Garage garage = null;

        if(currentUser != null) {
            String locations = location.getText();

            garage = new Garage(locations);
        }

        return garage;
    }

    public void createGarage() throws IOException {
        Garage garage = getGarageValues();

        if (garage == null || garage.getLocation().isEmpty()) {
            AppController.ShowAlertsErrorCreatingGarage();
        } else {
            GarageDAO tankDAO = new GarageDAO();

            if (tankDAO.exists(garage.getId())) {
                AppController.ShowAlertsGarageAlreadyExists();
            } else {
                if (tankDAO.saveGarage(garage, UserSession.getCurrentUser()) != null) {
                    AppController.ShowAlertsSuccessfullyCreateGarage();
                } else {
                    AppController.ShowAlertsErrorCreatingGarage();
                }
            }
        }
    }

    public void changeSceneToGarageConfig() throws IOException{
        App.currentController.changeScene(Scenes.GARAGECONFIG,null);
    }
}
