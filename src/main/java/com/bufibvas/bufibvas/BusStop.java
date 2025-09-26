package com.bufibvas.bufibvas;

public class BusStop {
    private String Name;
    private String Location;

    public BusStop(String name, String location) {
        Name = name;
        Location = location;
    }

    public String getName() {
        return Name;
    }
    public String getLocation() {
        return Location;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setLocation(String location) {
        Location = location;
    }
}
