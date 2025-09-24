package com.bufibvas.bufibvas;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;

@javax.inject.Named(value = "plannerController")
@javax.enterprise.context.SessionScoped
public class PlannerController implements Serializable {
    @Inject
    private BusLineList busLineList;

    private int status = 0;
    private BusLine selectedLine;
    private int selectedStartIdx;
    private int selectedEndIdx;
    private int totalTravelTime;
    private ArrayList<BusStop> usedStops;

    public BusLine getSelectedLine() {
        return selectedLine;
    }
    public String setSelectedLine(BusLine selectedLine) {
        this.selectedLine = selectedLine;
        this.status = 1;
        return "planner?faces-redirect=true";
    }
    public int getStatus() {
        return status;
    }
    public String setStatus(int status) {
        this.status = status;
        return "planner?faces-redirect=true";
    }
    public int getSelectedStartIdx() {
        return selectedStartIdx;
    }
    public void setSelectedStartIdx(int selectedStartIdx) {
        this.selectedStartIdx = selectedStartIdx;
    }
    public int getSelectedEndIdx() {
        return selectedEndIdx;
    }
    public void setSelectedEndIdx(int selectedEndIdx) {
        this.selectedEndIdx = selectedEndIdx;
    }
    public ArrayList<BusLine> getBusLines() {
        return busLineList.getBusLineList();
    }
    public ArrayList<BusStop> getBusStopList() {
        return selectedLine.getStopList();
    }

    public String clear() {
        selectedLine = null;
        selectedStartIdx = 0;
        selectedEndIdx = 0;
        status = 0;
        return "planner?faces-redirect=true";
    }
    public String deleteLine(BusLine line) {
        busLineList.removeBusLine(line);
        return "planner?faces-redirect=true";
    }
    public int idxOfStop(BusStop busStop) {
        return selectedLine.getStopList().indexOf(busStop);
    }
    public String confirmStops() {
        if (selectedStartIdx >= selectedEndIdx) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("popupMessage", "Zielhaltestelle muss nach der Starthaltestelle liegen!");
        }
        else {
            // wenn alles stimmt, berechne Fahrzeit und befahrene Stops
            totalTravelTime = 0;
            usedStops = new ArrayList<>();
            for (int i = selectedStartIdx; i <= selectedEndIdx; i++) {
                usedStops.add(selectedLine.getStopList().get(i));
                if (i == selectedStartIdx) continue;
                totalTravelTime += selectedLine.getTravelTimeMinutes(i);
            }
            this.status = 2;
        }
        return "planner?faces-redirect=true";
    }
    public int getTotalTravelTime() {
        return this.totalTravelTime;
    }
    public ArrayList<BusStop> getUsedStops() {
        return usedStops;
    }
    public String mapImgToStop(BusStop busStop, boolean useFullList) {
        int idx;
        if (useFullList) {
            idx = selectedLine.getStopList().indexOf(busStop);
            if (idx == 0) return "resources/img/start.png";
            if (idx == selectedLine.getStopList().size()-1) return "resources/img/end.png";
        }
        else {
            idx = usedStops.indexOf(busStop);
            if (idx == 0) return "resources/img/start.png";
            if (idx == usedStops.size()-1) return "resources/img/end.png";
        }
        return "resources/img/stop.png";
    }
}
