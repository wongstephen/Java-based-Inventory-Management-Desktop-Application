package ims.stephenwongc482.controller;

import ims.stephenwongc482.model.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.ModifyPartController.setPartToModify;
import static ims.stephenwongc482.controller.NavController.navigate;

public class MainController implements Initializable {


    public TableColumn prodIdCol;
    public TableColumn prodNameCol;
    public TableColumn prodStockCol;
    public TableColumn prodPriceCol;

    public TableColumn partIdCol;
    public TableColumn partNameCol;
    public TableColumn partStockCol;
    public TableColumn partPriceCol;

    public TableView allProductTable;
    public TableView allPartTable;
    public TextField partSearchInput;
    public TextField productSearchInput;

    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * RUNTIME ERROR: java.lang.NullPointerException
         *
         * Fixed by adding exports to module-info.java for model and controller
         */
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        prodIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        prodNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        prodStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        prodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        allProductTable.setItems(Inventory.getAllProducts());
        allPartTable.setItems(Inventory.getAllParts());
    }


    /**
     * creates a list of parts that match the search criteria
     *
     * @param partialName - partial name or id of part
     */
    private ObservableList<Part> searchPartByName(String partialName) {
        if (partialName == null || partialName.isEmpty()) {
            return Inventory.getAllParts();
        } else {
            ObservableList<Part> searchResults = FXCollections.observableArrayList();
            for (Part part : Inventory.getAllParts()) {
                if (part.getName().contains(partialName)) {
                    searchResults.add(part);
                }
            }
            return searchResults;
        }
    }
    /**
     * handles search input on main screen and searches for part by name or id
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        allPartTable.setItems(Inventory.getAllParts());
        String searchInputText = partSearchInput.getText();
        try {
            if (Integer.parseInt(searchInputText) > 0 && Integer.parseInt(searchInputText) < Inventory.getAllParts().size() + 1) {
                allPartTable.getSelectionModel().select(Integer.parseInt(searchInputText)-1);
            } else {
                System.out.println("Part not found");
                allPartTable.getSelectionModel().clearSelection();
                allPartTable.setItems(searchPartByName(searchInputText));
            }
        } catch (NumberFormatException e) {
            allPartTable.getSelectionModel().clearSelection();
            allPartTable.setItems(searchPartByName(searchInputText));
        }
    }
    /**
     * creates a list of parts that match the search criteria
     *
     * @param partialName - partial name
     */
    private ObservableList<Product> searchProductByName(String partialName) {
        if (partialName == null || partialName.isEmpty()) {
            return Inventory.getAllProducts();
        } else {
            ObservableList<Product> searchResults = FXCollections.observableArrayList();
            for (Product product : Inventory.getAllProducts()) {
                if (product.getName().contains(partialName)) {
                    searchResults.add(product);
                }
            }
            return searchResults;
        }
    }
    /**
     * handles search input on main screen and searches for part by name or id
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchProductSubmit(ActionEvent actionEvent) {
        allProductTable.setItems(Inventory.getAllProducts());
        String searchInputText = productSearchInput.getText();
        try {
            if (Integer.parseInt(searchInputText) > 0 && Integer.parseInt(searchInputText) < Inventory.getAllProducts().size() + 1) {
                allProductTable.getSelectionModel().select(Integer.parseInt(searchInputText)-1);
            } else {
                allProductTable.getSelectionModel().clearSelection();
                allProductTable.setItems(searchProductByName(searchInputText));
            }
        } catch (NumberFormatException e) {
            allProductTable.getSelectionModel().clearSelection();
            allProductTable.setItems(searchProductByName(searchInputText));
        }
    }
    /**
     * handles add part button on main screen click and navigates to add part screen
     *
     * @param actionEvent - add part button on main screen
     */
    @FXML
    void handleMainAddPartBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addPart");
    }

    /**
     * handles modify part button on main screen click and navigates to add part screen
     *
     * @param actionEvent - modify part button on main screen
     */
    @FXML
    void handleMainModifyPartBtn(ActionEvent actionEvent) throws IOException {
        try {
            Part selectedPart;
            if (allPartTable.getSelectionModel().getSelectedItem() instanceof Outsourced) {
                selectedPart = (Outsourced) allPartTable.getSelectionModel().getSelectedItem();
            } else {
                selectedPart = (InHouse) allPartTable.getSelectionModel().getSelectedItem();
            }
            if(selectedPart == null) {
                throw new NullPointerException();
            }
            setPartToModify(selectedPart);
            navigate(actionEvent, "modifyPart");
        } catch (NullPointerException e) {
            System.out.println("No part selected");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No part selected");
            alert.setContentText("Please select a part to modify");
            alert.showAndWait();

        }
    }

    @FXML
    void handleMainDeletePartBtn(ActionEvent actionEvent) {
        System.out.println("Main Delete Clicked");
    }

    /**
     * handles add product button on main screen click and navigates to add product screen
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainAddProductBtn(ActionEvent actionEvent) throws IOException {
        navigate(actionEvent, "addProduct");
    }

    /**
     * handles modify product button on main screen click and navigates to modify product screen
     *
     * @param actionEvent - modify product button on main screen
     */
    @FXML
    void handleMainModifyProductBtn(ActionEvent actionEvent) throws IOException {

        navigate(actionEvent, "modifyProduct");
    }

    /**
     * handles exit button on main screen click and exits app
     *
     * @param actionEvent - exit button on main screen
     */
    @FXML
    void handleExitBtn(ActionEvent actionEvent) {
        Platform.exit();
    }


}
