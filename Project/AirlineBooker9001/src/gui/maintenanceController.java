package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utility.FileHandler;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class maintenanceController
        implements Initializable {

    @FXML //fx:id="btnCancel"
    private Button btnCancel;

    @FXML //fx:id="btnSaveChanges"
    private Button btnSaveChanges;

    @FXML //fx:id="btnDelete"
    private Button btnDelete;

    @FXML //fx:id="cboAirports"
    private ComboBox cboAirport;

    @FXML //fx:id="txtAirport"
    private TextField txtAirport;

    @FXML //fx:id="txtAreaOrders"
    private TextArea txtAreaOrders;

    List<String> masterList;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        masterList = utility.FileHandler.readAirports();
        cboAirport.getItems().clear();
        cboAirport.setItems(FXCollections.observableList(masterList));
        cboAirport.getSelectionModel().selectFirst();
        cboAirport.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed (ObservableValue ov, String t, String t1){
//                Debugging
//                System.out.println(ov);
//                System.out.println(t);
//                System.out.println(t1);
                txtAirport.setText(cboAirport.getSelectionModel().getSelectedItem().toString());

            }
        });
        String content;

//        txtAreaOrders.setText(content);
    }
    @FXML
    private void cancel(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Main.mainstage.setTitle("Airline Booker 9001®");
            Main.mainstage.setScene(new Scene(root, 840, 680));
            Main.mainstage.show();

        }
        catch (Exception e1) {
            System.out.print(e1.getMessage());
        }
    }

    @FXML
    private void saveChanges(ActionEvent e) {
        try {
            FileHandler.updateAirports(cboAirport.getItems());
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Main.mainstage.setTitle("Airline Booker 9001®");
            Main.mainstage.setScene(new Scene(root, 840, 680));
            Main.mainstage.show();

        }
        catch (Exception e1) {
            System.out.print(e1.getMessage());
        }

    }
    @FXML
    private void addAirport(ActionEvent e){
        cboAirport.getItems().add(txtAirport.getText().toString());
    }
    @FXML
    private void deleteAirport(ActionEvent e){
        cboAirport.getItems().remove(txtAirport.getText().toString());
        cboAirport.getSelectionModel().selectFirst();
    }
}
