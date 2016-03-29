package gui;

import javafx.application.Platform;
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
import javafx.stage.Stage;
import utility.FileHandler;
import utility.Journey;
import utility.Type;

import java.net.URL;
import java.util.*;


public class mainController
        implements Initializable {


    @FXML //fx:id="btnExit"
    private Button btnExit;

    @FXML //fx:id="btnClear"
    private Button btnClear;

    @FXML //fx:id="btnConfirm"
    private Button btnConfirm;

    @FXML //fx:id="btnHelp"
    private Button btnHelp;

    @FXML //fx:id="cboDeparture"
    private ComboBox cboDeparture;

    @FXML //fx:id="cboDestination"
    private ComboBox cboDestination;

    @FXML //fx:id="cboDepartureReturn"
    private ComboBox cboDepartureReturn;

    @FXML //fx:id="cboDestinationReturn"
    private ComboBox cboDestinationReturn;

    @FXML //fx:id="cboDepartureJourney"
    private ComboBox cboDepartureJourney;

    @FXML //fx:id="cboDestinationJourney"
    private ComboBox cboDestinationJourney;

    @FXML //fx:id="txtName"
    private TextField txtName;

    @FXML //fx:id="txtId"
    private TextField txtId;

    @FXML //fx:id="txtPassword"
    private TextField txtPassword;

    @FXML //fx:id="rdoOneway"
    private RadioButton rdoOneway;

    @FXML //fx:id="rdoReturn"
    private RadioButton rdoReturn;

    @FXML //fx:id="rdoJourney"
    private RadioButton rdoJourney;

    @FXML //fx:id="rdoEconomy"
    private RadioButton rdoEconomy;

    @FXML //fx:id="rdoBusiness"
    private RadioButton rdoBusiness;

    @FXML //fx:id="rdoFirstClass"
    private RadioButton rdoFirstClass;

    @FXML //fx:id="chkCarryOn"
    private CheckBox chkCarryOn;

    public static Journey j;

    List<String> masterList;

    List<String> departureList = new ArrayList<String>();
    List<String> destinationList = new ArrayList<String>();
    List<String> departureReturnList = new ArrayList<String>();
    List<String> destinationReturnList = new ArrayList<String>();
    List<String> departureJourneyList = new ArrayList<String>();
    List<String> destinationJourneyList = new ArrayList<String>();

    ArrayList<String> clonedList = new ArrayList<String>();

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
/*****************************************************************************
/*        Automatically sets the txtPassword field to the appropriate password.
/*        For debugging, do not leave switched on in live client!
 *****************************************************************************/
//        txtPassword.setText("P@$$w0rd");

        masterList = FileHandler.getAirports();
        departureList.addAll(masterList);
        cboDeparture.getItems().clear();
        cboDeparture.setItems(FXCollections.observableList(departureList));
        cboDeparture.getSelectionModel().selectFirst();

        destinationList.addAll(masterList);
        cboDestination.getItems().clear();
        cboDestination.setItems(FXCollections.observableList(destinationList));
        cboDestination.getSelectionModel().selectLast();

        departureReturnList.addAll(masterList);
        cboDepartureReturn.getItems().clear();
        cboDepartureReturn.setItems(FXCollections.observableList(departureReturnList));
        cboDepartureReturn.getSelectionModel().selectFirst();

        destinationReturnList.addAll(masterList);
        cboDestinationReturn.getItems().clear();
        cboDestinationReturn.setItems(FXCollections.observableList(destinationReturnList));
        cboDestinationReturn.getSelectionModel().selectLast();

        departureJourneyList.addAll(masterList);
        cboDepartureJourney.getItems().clear();
        cboDepartureJourney.setItems(FXCollections.observableList(departureJourneyList));
        cboDepartureJourney.getSelectionModel().selectFirst();

        destinationJourneyList.addAll(masterList);
        cboDestinationJourney.getItems().clear();
        cboDestinationJourney.setItems(FXCollections.observableList(destinationJourneyList));
        cboDestinationJourney.getSelectionModel().selectLast();
        initialiseNewTrip();
        cboDeparture.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed (ObservableValue ov, String t, String t1){
                updateDestinationList();
            }
        });
        cboDepartureReturn.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed (ObservableValue ov, String t, String t1){
                updateDestinationReturnList();
            }
        });
        cboDepartureJourney.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed (ObservableValue ov, String t, String t1){
                updateDestinationJourneyList();
            }
        });
    }

    @FXML
    private void handleExit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void generatePreview(ActionEvent e) {
        if (txtName.getText().length()>0){ // If username is not blank
            String seatType = "";
            Boolean carryOn = false;
            // Radio button logic for Seat type
            if (rdoEconomy.isSelected()){
                seatType = Type.ECONOMY;
            }
            else if (rdoBusiness.isSelected()){
                seatType = Type.BUSINESS;
            }
            else if (rdoFirstClass.isSelected()){
                seatType = Type.FIRSTCLASS;
            }
            // Checkbox logic for Carry-on Luggage
            if (chkCarryOn.isSelected()){
                carryOn = true;
            }
            // Create a new journey object
            j = new Journey((txtId.getText()), txtName.getText(), seatType, carryOn);
            if (rdoOneway.isSelected()) {
                j._type = Type.ONEWAY;
                HashMap<String,String> trip= new HashMap<String,String>(); //Create a new Hashmap object
                //Add each leg of the trip to the hashmap
                trip.put(cboDeparture.getSelectionModel().getSelectedItem().toString(), cboDestination.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.ONEWAY, trip);
            } else if (rdoReturn.isSelected()) {
                j._type = Type.RETURN;
                HashMap<String,String> trip= new HashMap<String,String>();
                trip.put(cboDeparture.getSelectionModel().getSelectedItem().toString(), cboDestination.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.ONEWAY, trip);
                trip = new HashMap<String, String>();
                trip.put(cboDepartureReturn.getSelectionModel().getSelectedItem().toString(), cboDestinationReturn.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.RETURN, trip);
            } else if (rdoJourney.isSelected()) {
                j._type = Type.JOURNEY;
                HashMap<String,String> trip= new HashMap<String,String>();
                trip.put(cboDeparture.getSelectionModel().getSelectedItem().toString(), cboDestination.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.ONEWAY, trip);
                trip = new HashMap<String, String>();
                trip.put(cboDepartureReturn.getSelectionModel().getSelectedItem().toString(), cboDestinationReturn.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.RETURN, trip);
                trip = new HashMap<String, String>();
                trip.put(cboDepartureJourney.getSelectionModel().getSelectedItem().toString(), cboDestinationJourney.getSelectionModel().getSelectedItem().toString());
                j._trips.put(Type.JOURNEY, trip);
            }
            try {
                Parent root = FXMLLoader.load(getClass().getResource("preview.fxml"));
                Main.mainstage.setTitle("Airline Booker 9001®");
                Main.mainstage.setScene(new Scene(root, 840, 680));
                Main.mainstage.show();
            }
            catch (Exception e1) {
                System.out.print(e1.getCause());
                System.out.print(e1.toString());
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Please enter a customer name!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void showHelp(){
        try {
            //Help button loader
            System.out.println("1");
            Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Airline Booker 9001® Help");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.print(e.getCause() + "\n");
            System.out.print(e.getMessage() + "\n");
            System.out.print(e.getStackTrace().toString() + "\n");
            e.printStackTrace();
            System.out.print(e.toString());
            System.err.println(e);
        }
    }

    @FXML
    private void selectJourneyType(ActionEvent e) {
        cboDepartureReturn.setDisable(false);
        cboDestinationReturn.setDisable(false);
        cboDepartureJourney.setDisable(false);
        cboDestinationJourney.setDisable(false);
    }

    @FXML
    private void selectReturnType(ActionEvent e) {
        cboDepartureReturn.setDisable(false);
        cboDestinationReturn.setDisable(false);
        cboDepartureJourney.setDisable(true);
        cboDestinationJourney.setDisable(true);
        cboDepartureReturn.setValue(cboDestination.getSelectionModel().getSelectedItem());
        cboDestinationReturn.setValue(cboDeparture.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void selectOnewayType(ActionEvent e) {
        cboDepartureReturn.setDisable(true);
        cboDestinationReturn.setDisable(true);
        cboDepartureJourney.setDisable(true);
        cboDestinationJourney.setDisable(true);
    }

    private void updateDestinationList(){
        destinationList.clear();
        destinationList.addAll(masterList);
        destinationList.remove(cboDeparture.getSelectionModel().getSelectedIndex());
        cboDestination.setItems(FXCollections.observableList(destinationList));
    }

    private void updateDestinationReturnList(){
        destinationReturnList.clear();
        destinationReturnList.addAll(masterList);
        destinationReturnList.remove(cboDepartureReturn.getSelectionModel().getSelectedIndex());
        cboDestinationReturn.setItems(FXCollections.observableList(destinationReturnList));
    }

    private void updateDestinationJourneyList(){
        destinationJourneyList.clear();
        destinationJourneyList.addAll(masterList);
        destinationJourneyList.remove(cboDepartureJourney.getSelectionModel().getSelectedIndex());
        cboDestinationJourney.setItems(FXCollections.observableList(destinationJourneyList));
    }

    @FXML
    private void clear(ActionEvent e){
        initialiseNewTrip();
    }

    @FXML
    private void maintenanceMode(ActionEvent e) {
        String password = "P@$$w0rd";
        if (txtPassword.getText().equals(password)){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("maintenance.fxml"));
                Main.mainstage.setTitle("Airline Booker 9001®");
                Main.mainstage.setScene(new Scene(root, 840, 680));
                Main.mainstage.show();
            }
            catch (Exception e1) {
                System.out.print(e1.getCause());
                System.out.print(e1.toString());
                System.err.println(e1);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Maintenance Password!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    private void initialiseNewTrip(){
        txtId.setText(UUID.randomUUID().toString());
        updateDestinationList();
        updateDestinationReturnList();
        updateDestinationJourneyList();
    }
}
