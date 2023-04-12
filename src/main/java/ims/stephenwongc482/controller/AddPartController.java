package ims.stephenwongc482.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static ims.stephenwongc482.controller.NavController.navigate;


public class AddPartController {


    public Label sourceLabel;

    /**
     * Saves new part to inventory
     */
    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        // Save Data then navigate to main
        navigate(actionEvent, "mainScreen");
    }

    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    public void onInHouse(ActionEvent actionEvent) {
        sourceLabel.setText("Machine ID");
    }

    public void onOutsourced(ActionEvent actionEvent) {
        sourceLabel.setText("Company Name");
    }
}
