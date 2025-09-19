package com.bufibvas.bufibvas;

import java.util.ArrayList;
import java.util.Objects;

public class BusLine {
    String Id;
    ArrayList<BusStop> Stops;

    public BusLine(String id) {
        Id = id;
        Stops = new ArrayList<>();
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getRoute() {
        StringBuilder route = new StringBuilder();
        for (BusStop stop : Stops) {
            route.append(stop.Name);
            route.append(" - ");
        }
        route.delete(route.length() - 3, route.length());
        return route.toString();
    }
    public ArrayList<BusStop> getStops() {
        return Stops;
    }
    public void addStop(BusStop stop) {
        Stops.add(stop);
    }
    public BusStop getStop(String name) {
        for (BusStop stop : Stops) {
            if (Objects.equals(stop.Name, name)) {
                return stop;
            }
        }
        return null;
    }
    public BusStop getStop(int index) {
        return Stops.get(index);
    }
}
