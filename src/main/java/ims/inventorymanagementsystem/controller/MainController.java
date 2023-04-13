package ims.inventorymanagementsystem.controller;

import ims.inventorymanagementsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    Stage stage;
    Parent scene;

    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
    }

    // Opens Add Parts Menu in new scene
    // RUNTIME ERROR when there is no IOException. GetClass().getResource did not work. Used code from new project template Main.class.getResource to get it functional.
    // FUTURE ENHANCEMENT refactor in to try catch block.

    void navigate(ActionEvent actionEvent, String location) throws IOException{
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("view/"+location+".fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void handleMainAddPartBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addPart");
    }
    @FXML
    void handleMainModifyPartBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "modifyPart");
    }
    @FXML
    void handleMainDeletePartBtn(ActionEvent actionEvent) {
        System.out.println("Main Delete Clicked");
    }

    @FXML
    void handleMainSearchProductSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
    }

    //    Opens Add Products Menu in new scene
    @FXML
    void handleMainAddProductBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addProduct");
    }
    @FXML
    void handleMainModifyProductBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "modifyProduct");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}