package ims.stephenwongc482.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ims.stephenwongc482.controller.NavController.navigate;

public class MainController implements Initializable {

    /**
     * initalizes app
     *
     * @param url - url
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * TODO Part Search
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
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
        navigate(actionEvent, "modifyPart");
    }

    @FXML
    void handleMainDeletePartBtn(ActionEvent actionEvent) {
        System.out.println("Main Delete Clicked");
    }

    /**
     * TODO Product Search
     *
     * @param actionEvent - add product button on main screen
     */
    @FXML
    void handleMainSearchProductSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
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
