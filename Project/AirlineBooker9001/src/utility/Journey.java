package utility;

import java.util.HashMap;


/**
 * Created by Juan on 19/03/16.
 */
public class Journey {
    public String _referenceID;
    public String _userName;
    public HashMap<Integer, HashMap<String, String>> _trips;
    public HashMap<String, String> _stages;
    public String _seatType;

//    public List stages;
    public int _type;

    public Journey(String ID, String userName, String seatType){
        _referenceID = ID;
        _userName = userName;
        _seatType = seatType;
        _type = Type.ONEWAY;



        _trips = new HashMap<Integer, HashMap<String,String>>();
    }

    public Journey getJourney(){
        return this;
    }
}
