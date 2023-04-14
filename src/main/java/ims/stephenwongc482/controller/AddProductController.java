package ims.stephenwongc482.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static ims.stephenwongc482.controller.NavController.navigate;

public class AddProductController {

    /**
     * Saves new product to inventory
     *
     * @param actionEvent - button on product screen
     */
    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        // Save Data then navigate to main
        navigate(actionEvent, "mainScreen");
    }

    /**
     * cancels addition of new product and navigates back to main screen
     *
     * @param actionEvent - button on product screen
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }
}