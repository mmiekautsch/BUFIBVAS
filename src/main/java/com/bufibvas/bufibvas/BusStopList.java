package com.bufibvas.bufibvas;

import java.util.ArrayList;

@javax.enterprise.context.ApplicationScoped
public class BusStopList {
    ArrayList<BusStop> busStopList;
    public BusStopList() {
        busStopList = new ArrayList<>();
        busStopList.add(new BusStop("Hauptbahnhof", "Altstadt"));
        busStopList.add(new BusStop("Altmarkt", "Altstadt"));
        busStopList.add(new BusStop("Postplatz", "Altstadt"));
        busStopList.add(new BusStop("Großer Garten", "Südvorstadt"));
        busStopList.add(new BusStop("Zoo", "Südvorstadt"));
        busStopList.add(new BusStop("Technische Universität", "Südvorstadt"));
        busStopList.add(new BusStop("Nürnberger Platz", "Südvorstadt"));
        busStopList.add(new BusStop("Neustadt Bahnhof", "Neustadt"));
        busStopList.add(new BusStop("Albertplatz", "Neustadt"));
        busStopList.add(new BusStop("Elbwiesen", "Neustadt"));
    }

    public void addBusStop(BusStop busStop) {
        busStopList.add(busStop);
    }
}
