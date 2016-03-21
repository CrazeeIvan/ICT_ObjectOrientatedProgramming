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
import javafx.scene.control.*;
import utility.FileHandler;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class maintenanceController
        implements Initializable {

    @FXML //fx:id="btnCancel"
    private Button btnCancel;

    @FXML //fx:id="btnSaveChanges"
    private Button btnSaveChanges;

    @FXML //fx:id="btnAdd"
    private Button btnAdd;

    @FXML //fx:id="btnDelete"
    private Button btnDelete;

    @FXML //fx:id="cboAirports"
    private ComboBox cboAirport;

    @FXML //fx:id="txtAirport"
    private TextField txtAirport;

    @FXML //fx:id="txtAreaOrders"
    private TextArea txtAreaOrders;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        List<String> masterList;
        masterList = utility.FileHandler.getAirports();
        cboAirport.getItems().clear();
        cboAirport.setItems(FXCollections.observableList(masterList));
        cboAirport.getSelectionModel().selectFirst();
        txtAirport.setText(cboAirport.getSelectionModel().getSelectedItem().toString());
        cboAirport.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed (ObservableValue ov, String t, String t1){
                txtAirport.setText(cboAirport.getSelectionModel().getSelectedItem().toString());
                txtAirport.setDisable(true);
            }
        });
        String content;
        content = FileHandler.getTrips();
        txtAreaOrders.setText(content);
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
            System.out.print(e1.getCause());
            System.out.print(e1.toString());
        }
    }
    @FXML
    private void saveChanges(ActionEvent e) {
        try {
            FileHandler.saveAirports(cboAirport.getItems());
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Main.mainstage.setTitle("Airline Booker 9001®");
            Main.mainstage.setScene(new Scene(root, 840, 680));
            Main.mainstage.show();
        }
        catch (Exception e1) {
            System.out.print(e1.getCause());
            System.out.print(e1.toString());
        }
    }
    @FXML
    private void addAirport(ActionEvent e){
        if (cboAirport.getItems().contains(txtAirport.getText())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Airport already exists!");
            Optional<ButtonType> result = alert.showAndWait();
        }
        else {
            cboAirport.getItems().add(txtAirport.getText());
        }
    }
    @FXML
    private void deleteAirport(ActionEvent e){
        cboAirport.getSelectionModel().clearSelection();
        cboAirport.getItems().remove(txtAirport.getText());
        txtAirport.setText("");
    }
}