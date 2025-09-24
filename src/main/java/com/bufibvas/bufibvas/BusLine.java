package com.bufibvas.bufibvas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class BusLine {
    private final ArrayList<BusStop> StopList;
    private final ArrayList<Integer> TravelTimes;
    private String Id;
    private Date workinghrsStart;
    private Date workinghrsEnd;

    public BusLine(String id, Date workingHoursstart, Date workingHoursend, BusStop start) {
        Id = id;
        workinghrsStart = workingHoursstart;
        workinghrsEnd = workingHoursend;
        StopList = new ArrayList<>();
        TravelTimes = new ArrayList<>();
        StopList.add(start);
        TravelTimes.add(0);
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getWorkinghrs() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return String.format("%s bis %s", sdf.format(workinghrsStart), sdf.format(workinghrsEnd));
    }

    public ArrayList<BusStop> getStopList() {
        return StopList;
    }

    public void addStop(BusStop busStop, int travelTimeMinutes) {
        StopList.add(busStop);
        TravelTimes.add(travelTimeMinutes);
    }

    public void removeStop(BusStop busStop) {
        TravelTimes.remove(StopList.indexOf(busStop));
        StopList.remove(busStop);
    }

    public int getTravelTimeMinutes(int idx) {
        return TravelTimes.get(idx);
    }
    public int getTravelTimeMinutes(BusStop busStop) {
        return TravelTimes.get(StopList.indexOf(busStop));
    }
}
