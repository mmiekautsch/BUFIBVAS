package com.bufibvas.bufibvas;

public class BusStop {
    String Name;
    String Location;
    int minsFromPrevStop;

    public BusStop(String name, String location) {
        Name = name;
        Location = location;
        minsFromPrevStop = 0;
    }
}
