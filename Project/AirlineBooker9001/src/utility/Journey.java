package utility;

import java.util.HashMap;

public class Journey {
    public String _referenceID;
    public String _userName;
    public HashMap<Integer, HashMap<String, String>> _trips;
    public HashMap<String, String> _stages;
    public String _seatType;
    public Boolean _carryOn;
    public int _type;

    public Journey(String ID, String userName, String seatType, Boolean carryOn){
        _referenceID = ID;
        _userName = userName;
        _seatType = seatType;
        _type = Type.ONEWAY;
        _carryOn = carryOn;
        _trips = new HashMap<Integer, HashMap<String,String>>();
    }
}
