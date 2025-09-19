package com.bufibvas.bufibvas;

import java.util.ArrayList;

public class BusStopList {
    ArrayList<BusStop> busStopList;
    public BusStopList() {
        busStopList = new ArrayList<>();
        busStopList.add(new BusStop("Hauptbahnhof", "Altstadt", "Zentraler Umstiegspunkt, alle Linien"));
        busStopList.add(new BusStop("Altmarkt", "Altstadt", "Direkt am Einkaufszentrum, viel Publikumsverkehr"));
        busStopList.add(new BusStop("Postplatz", "Altstadt", "Knotenpunkt mit Straßenbahnanschluss"));
        busStopList.add(new BusStop("Großer Garten", "Südvorstadt", "Haltestelle am Parkeingang"));
        busStopList.add(new BusStop("Zoo", "Südvorstadt", "Nähe Tierpark, viele Touristen"));
        busStopList.add(new BusStop("Technische Universität", "Südvorstadt", "Viele Studierende, werktags stark frequentiert"));
        busStopList.add(new BusStop("Nürnberger Platz", "Südvorstadt", ""));
        busStopList.add(new BusStop("Neustadt Bahnhof", "Neustadt", "Regionalzug- und S-Bahn-Anschluss"));
        busStopList.add(new BusStop("Albertplatz", "Neustadt", "Wichtiger Verkehrsknoten mit vielen Umstiegen"));
        busStopList.add(new BusStop("Elbwiesen", "Neustadt", "Beliebt im Sommer, Eventfläche"));
    }

}
