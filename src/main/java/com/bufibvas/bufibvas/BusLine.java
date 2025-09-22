package com.bufibvas.bufibvas;

import java.time.LocalTime;
import java.util.ArrayList;

public class BusLine {
    private final ArrayList<BusStop> StopList;
    private final ArrayList<LocalTime> Schedule;
    private String Id;
    private String workingHours;

    public BusLine(String id, String workingHours) {
        Id = id;
        this.workingHours = workingHours;
        StopList = new ArrayList<>();
        Schedule = new ArrayList<>();
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getWorkingHours() {
        return workingHours;
    }
    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public ArrayList<BusStop> getStopList() {
        return StopList;
    }

    public void addSchedule(BusStop busStop) {
        StopList.add(busStop);
    }
}
