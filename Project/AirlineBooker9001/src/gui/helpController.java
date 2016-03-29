package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import utility.FileHandler;

import java.net.URL;
import java.util.ResourceBundle;


public class helpController
        implements Initializable {

    @FXML //fx:id="btnClose"
    private Button btnClose;

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML //fx:id="txtAreaHelp"
    private TextArea txtAreaHelp;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        String content;
        content = FileHandler.getHelp();
        txtAreaHelp.setText(content);
    }
    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) btnClose.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
