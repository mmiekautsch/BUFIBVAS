package com.bufibvas.bufibvas;

import javax.inject.Inject;
import java.io.Serializable;

@javax.inject.Named(value = "busLineCreatorController")
@javax.enterprise.context.RequestScoped
public class BusStopCreatorController implements Serializable {
    @Inject
    private BusStopList busStopList;
    private String Name;
    private String Location;
    private boolean firstLoad = false;

    public void createBusStop() {
        BusStop stop = new BusStop(Name, Location);
        busStopList.addBusStop(stop);
    }

    public void clear() {
        Name = "";
        Location = "";
        firstLoad = false;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
}
