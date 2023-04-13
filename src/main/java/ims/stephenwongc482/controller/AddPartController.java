package ims.stephenwongc482.controller;

import ims.stephenwongc482.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPartController {
    Stage stage;
    Parent scene;

    //    Nav function to make setting screen to main less redundant
    void navigateToMain(ActionEvent actionEvent) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("view/mainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        // Save Data then navigate to main
        navigateToMain(actionEvent);
    }
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigateToMain(actionEvent);
    }
}
