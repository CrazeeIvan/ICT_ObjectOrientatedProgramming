package gui;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utility.FileHandler;
import utility.Journey;
import utility.Type;

import java.net.URL;
import java.util.*;


public class helpController
        implements Initializable {
    @FXML //fx:id="btnNewStage"
    Button btnNewStage;

    @FXML //fx:id="pneHelp"
    Pane pneHelp;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        btnNewStage.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Stage stage = new Stage();
                //Fill stage with content
                stage.show();
            }
        });

        BackgroundImage myBI= new BackgroundImage(new Image("C:\\Users\\Ciaran\\Documents\\ICT_ObjectOrientatedProgramming\\Project\\AirlineBooker9001\\src\\gui\\maintenanceHelp.png",32,32,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//then you set to your node
        pneHelp.setBackground(new Background(myBI));

    }

    @FXML
    private void handleExit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }


}
