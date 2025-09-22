package com.bufibvas.bufibvas;

import java.util.ArrayList;

@javax.enterprise.context.ApplicationScoped
public class BusLineList {
    private final ArrayList<BusLine> busLineList;

    public BusLineList() {
        busLineList = new ArrayList<>();
        busLineList.add(new BusLine("42",  "12:00 - 22:00"));
        busLineList.add(new BusLine("61", "12:00 - 22:00"));
        busLineList.add(new BusLine("85", "12:00 - 22:00"));
        busLineList.add(new BusLine("7", "12:00 - 22:00"));
        busLineList.add(new BusLine("12", "12:00 - 22:00"));
    }
    public ArrayList<BusLine> getBusLineList() {
        return busLineList;
    }

    public void addBusLine(BusLine busLine) {
        busLineList.add(busLine);
    }

    public void removeBusLine(BusLine busLine) {
        if (busLine != null) {
            busLineList.remove(busLine);
        }
    }
}
