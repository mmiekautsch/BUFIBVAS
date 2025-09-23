package com.bufibvas.bufibvas;

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

    public ArrayList<BusStop> getStopList() {
        return StopList;
    }

    public void addStop(BusStop busStop, int travelTimeMinutes) {
        StopList.add(busStop);
        TravelTimes.add(travelTimeMinutes);
    }
}
