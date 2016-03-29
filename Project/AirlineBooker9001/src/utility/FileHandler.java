package utility;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileHandler {
    //Edit path to the required filepath
    public static String path = "C:\\Users\\Ciaran\\Documents\\ICT_ObjectOrientatedProgramming\\Project\\AirlineBooker9001\\src\\gui\\";
    //College Path:
    //  C:\Users\blue20\Documents\ICT_ObjectOrientatedProgramming\Project\AirlineBooker9001\src\gui\
    //home Path:
    // C:\Users\Ciaran\Documents\ICT_ObjectOrientatedProgramming\Project\AirlineBooker9001\src\gui\

    //Filenames for each of the documents we use. (Airports list = airports.csv, Help information = help.txt, New orders file = orders.txt
    public static String airportsFile = path + "airports.csv";
    public static String helpFilePath = path + "help.txt";
    public static String ordersFilePath = "orders.txt";

    public static ArrayList<String> getAirports() { //Reads airports from airports file and sorts them. Returns a list of sorted airports.
        File file = new File(airportsFile);
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.next();
                list.add(data);
            }
            java.util.Collections.sort(list); // Sorts the list of read airports
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Boolean saveAirports(ObservableList l) { //Save airports to the airports file
        Boolean saved;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(airportsFile))) {
            for (Object o : l) {
                bw.write(o.toString() + "\n");
            }
            bw.close();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
            saved = false;
        }
        return saved;
    }
    public static Boolean saveTrip(Journey j) { // Format trip details and saves them to file
        Boolean saved;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ordersFilePath, true))) {
            bw.write("\n\n" + "Username: " + j._userName + "\n" + "Booking ID: " + j._referenceID + "\n" + "Journey Legs: " + j._type + "\n" + "Seat Type: " + j._seatType + "\n" + "Carry-on: " + "\n" + j._carryOn);
            bw.write("\nJourney Details:");
            for (HashMap.Entry<Integer, HashMap<String, String>> entry : j._trips.entrySet()) {
                bw.write("\nLeg: " + entry.getKey() + "\nDeparture/Destination:\n" + entry.getValue() + "\n");
            }
            bw.close();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
            saved = false;
        }
        return saved;
    }
    public static String getTrips(){ // Reads orders from orders file. Returns a string of all airports.
        String content = "";
        try {
            Scanner s = new Scanner(new File("orders.txt"));
            while (s.hasNext()) {
                content += s.nextLine().toString() + "\n";
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        return content;
    }

    public static String getHelp() { // Reads help from the help file. Returns a string of help.
        String message = "";
        try {
            File file = new File(helpFilePath);

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                message += input.nextLine() + "\n";
            }
            input.close();
        } catch (Exception e) {
            System.out.print(e.getCause());
            System.out.print(e.toString());
        }
        return message;
    }
}