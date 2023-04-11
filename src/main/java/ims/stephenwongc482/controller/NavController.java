package ims.stephenwongc482.controller;

import ims.stephenwongc482.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class NavController {
    static Stage stage;
    static Parent scene;

    // RUNTIME ERROR when there is no IOException. GetClass().getResource did not work. Used code from new project template Main.class.getResource to get it functional.
    // FUTURE ENHANCEMENT refactor in to try catch block.
    /**
     * navigates to desired location when called. Used for navigation between screens.
     *
     * @param actionEvent - button on main screen, location - string of location to navigate to
     */
    static void navigate(ActionEvent actionEvent, String location) throws IOException {
        stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("view/"+location+".fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

}
