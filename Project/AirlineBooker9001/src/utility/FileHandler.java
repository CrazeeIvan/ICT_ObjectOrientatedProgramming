package utility;

/**
 * Created by Juan on 19/03/16.
 */

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class FileHandler {
    public static String airportsFile = "/Users/Juan/Documents/huxlley/AirlineBooker9001/src/gui/airports.csv";
    // -File class needed to turn stringName to actual file
    public static ArrayList<String> readAirports() {
        // -define .csv file in app

        File file = new File(airportsFile);
        ArrayList<String> list = new ArrayList<String>();


        try{
            // read from file with Scanner class
            Scanner inputStream = new Scanner(file);

            // hashNext() loops line-by-line
            while(inputStream.hasNext()){
                //read single line, put in string
                String data = inputStream.next();
                list.add(data);
            }
            java.util.Collections.sort(list);

            // after loop, close scanner
            inputStream.close();


        }catch (FileNotFoundException e){

            e.printStackTrace();
        }

        return list;
    }
    public static Boolean confirmBooking(Journey j){
        Boolean saved;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("orders.txt", true))) {

            bw.write("\n\n" + j._userName + "\n"  + j._referenceID + "\n" + j._type + "\n");

            bw.write("Journey Details:");
            for (HashMap.Entry<Integer, HashMap<String, String>> entry : j._trips.entrySet())
            {

                bw.write("\n" + entry.getKey() + "\n" + entry.getValue() + "\n" );
            }


            bw.close();
            saved = true;
        } catch (IOException e) {
            e.printStackTrace();
            saved = false;
        }
        return saved;
    }
    public static Boolean updateAirports(ObservableList l){
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
}
