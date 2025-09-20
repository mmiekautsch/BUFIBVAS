package com.bufibvas.bufibvas;

import java.util.ArrayList;

public class BusLine {
    private String Id;
    private ArrayList<BusStop> Schedule;
    private String workingHours;

    public BusLine(String id, String workingHours) {
        Id = id;
        this.workingHours = workingHours;
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

    public ArrayList<BusStop> getSchedule() {
        return Schedule;
    }

    public void addSchedule(BusStop busStop) {
        Schedule.add(busStop);
    }
}
