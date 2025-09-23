package com.bufibvas.bufibvas;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@javax.enterprise.context.ApplicationScoped
public class BusLineList {
    private final ArrayList<BusLine> busLineList;

    public BusLineList() throws ParseException {
        busLineList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        busLineList.add(new BusLine("42", sdf.parse("12:00"), sdf.parse("22:00"), new BusStop("Hauptbahnhof", "Altstadt")));
        busLineList.add(new BusLine("61", sdf.parse("12:00"), sdf.parse("22:00"), new BusStop("Altmarkt", "Altstadt")));
        busLineList.add(new BusLine("85", sdf.parse("12:00"), sdf.parse("22:00"), new BusStop("Postplatz", "Altstadt")));
        busLineList.add(new BusLine("7", sdf.parse("12:00"), sdf.parse("22:00"), new BusStop("Großer Garten", "Südvorstadt")));
        busLineList.add(new BusLine("12", sdf.parse("12:00"), sdf.parse("22:00"), new BusStop("Zoo", "Südvorstadt")));
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
