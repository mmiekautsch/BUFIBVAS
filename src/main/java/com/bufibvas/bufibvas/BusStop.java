package com.bufibvas.bufibvas;

public class BusStop {
    String Name;
    String Location;
    int driveTimeFromPrevStop;

    public BusStop(String name, String location) {
        Name = name;
        Location = location;
        driveTimeFromPrevStop = 0;
    }
}
