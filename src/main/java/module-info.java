module ims.stephenwongc482 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ims.stephenwongc482 to javafx.fxml;
    exports ims.stephenwongc482;
    exports ims.stephenwongc482.controller;
    opens ims.stephenwongc482.controller to javafx.fxml;
    exports ims.stephenwongc482.model;

}