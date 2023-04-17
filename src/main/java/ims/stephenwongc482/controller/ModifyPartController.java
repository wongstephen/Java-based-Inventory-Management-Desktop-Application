package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.InHouse;
import ims.stephenwongc482.model.Outsourced;
import ims.stephenwongc482.model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;

public class ModifyPartController implements Initializable {

    public Label sourceLabel;
    public static Part partToModify = null;
    public TextField modifyIdInput;
    public TextField modifyNameInput;
    public TextField modifyStockInput;
    public TextField modifyPriceInput;
    public TextField modifyMaxInput;
    public TextField modifySourceInput;
    public TextField modifyMinInput;
    public RadioButton inHouseRadio;
    public RadioButton outsourcedRadio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyIdInput.setText(String.valueOf(partToModify.getId()));
        modifyNameInput.setText(partToModify.getName());
        modifyStockInput.setText(String.valueOf(partToModify.getStock()));
        modifyPriceInput.setText(String.valueOf(partToModify.getPrice()));
        modifyMaxInput.setText(String.valueOf(partToModify.getMax()));
        modifyMinInput.setText(String.valueOf(partToModify.getMin()));
        if (partToModify instanceof InHouse) {
            modifySourceInput.setText(String.valueOf(((InHouse) partToModify).getMachineId()));
            inHouseRadio.setSelected(true);
        } else {
            modifySourceInput.setText(((Outsourced) partToModify).getCompanyName());
            outsourcedRadio.setSelected(true);
        }
    }

    public static void setPartToModify(Part part) {
        partToModify = part;
        System.out.println("Part to modify: " + partToModify.getName());
    }



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
