package ims.stephenwongc482.controller;

import ims.stephenwongc482.Main;
import javafx.application.Platform;
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

    /**
     * initalizes app
     *
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    Stage stage;
    Parent scene;

    @FXML
    void handleMainSearchPartSubmit(ActionEvent actionEvent) {
        System.out.println("Enter Search Part Pressed");
    }

    // Opens Add Parts Menu in new scene
    // RUNTIME ERROR when there is no IOException. GetClass().getResource did not work. Used code from new project template Main.class.getResource to get it functional.
    // FUTURE ENHANCEMENT refactor in to try catch block.
     /**
     * navigates to desired location when called
     *
     * @param actionEvent - button on main screen, location - string of location to navigate to
     */
    void navigate(ActionEvent actionEvent, String location) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("view/"+location+".fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
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
     * TODO Search
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
     * exits app
     *
     * @param actionEvent - exit button on main screen
     */
    @FXML
    void handleExitBtn (ActionEvent actionEvent) {
        Platform.exit();
    }


}
