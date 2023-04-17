package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.Inventory;
import ims.stephenwongc482.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;

public class ModifyProductController implements Initializable {
    public static Product productToModify = null;
    public TextField modifyProductIdInput;
    public TextField modifyProductNameInput;
    public TextField modifyProductStockInput;
    public TextField modifyProductPrice;
    public TextField modifyProductMax;
    public TextField modifyProductMin;
    public TableView allPartsTable;

    // Associated part controls
    public Button addAssPart;
    public Button removeAssPart;
    public TableView allPartTable;
    public TableColumn allPartIdCol;
    public TableColumn allPartNameCol;
    public TableColumn allPartStockCol;
    public TableColumn allPartPriceCol;

    public static void setProductToModify(Product product) {
        productToModify = product;
    }

    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifyProductIdInput.setText(String.valueOf(productToModify.getId()));
        modifyProductNameInput.setText(productToModify.getName());
        modifyProductStockInput.setText(String.valueOf(productToModify.getStock()));
        modifyProductPrice.setText(String.valueOf(productToModify.getPrice()));
        modifyProductMax.setText(String.valueOf(productToModify.getMax()));
        modifyProductMin.setText(String.valueOf(productToModify.getMin()));

        allPartTable.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    @FXML
    void handleSaveBtn(ActionEvent actionEvent) throws IOException {
        // Save Data then navigate to main
        navigate(actionEvent, "mainScreen");
    }

    /**
     * discards inputs in text fields then navigates to main screen
     *
     * @param actionEvent - action event
     * @throws IOException - io exception
     */
    @FXML
    void handleCancelBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "mainScreen");
    }

    @FXML
    void handleAddAssPart(ActionEvent actionEvent) {

    }

    @FXML
    void handleRemoveAssPart(ActionEvent actionEvent) {

    }


}

