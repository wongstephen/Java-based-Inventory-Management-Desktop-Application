package ims.stephenwongc482.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Scanner;

import static ims.stephenwongc482.controller.NavController.navigate;


public class AddPartController {
    public TextField nameInput;
    public TextField stockInput;
    public TextField priceInput;
    public TextField minInput;
    public TextField maxInput;
    public TextField sourceInput;
    public RadioButton inHouseRadio;
    public RadioButton outsourcedRadio;


    Scanner sc = new Scanner(System.in);
    public Label sourceLabel;

    /**
     * Saves new part to inventory
     *
     * @param actionEvent - button on add screen
     */
    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        // Save Data then navigate to main

        System.out.println(inHouseRadio.isSelected());
        System.out.println(outsourcedRadio.getText());
//        System.out.println(nameInput.getText());
//        System.out.println(stockInput.getText());
//        System.out.println(priceInput.getText());
//        System.out.println(minInput.getText());
//        System.out.println(maxInput.getText());
//        System.out.println(maxInput.getText());
//        navigate(actionEvent, "mainScreen");
    }

    /**
     * cancels addition of new part and navigates back to main screen
     *
     * @param actionEvent - button on add screen
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    /**
     * changes label to machine ID when in house is selected
     *
     * @param actionEvent - radio button
     */
    public void onInHouse(ActionEvent actionEvent) {
        sourceLabel.setText("Machine ID");
    }

    /**
     * changes label to company name when outsourced is selected
     *
     * @param actionEvent - radio button
     */
    public void onOutsourced(ActionEvent actionEvent) {
        sourceLabel.setText("Company Name");
    }


}
