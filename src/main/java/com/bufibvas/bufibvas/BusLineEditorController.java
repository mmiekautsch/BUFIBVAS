package com.bufibvas.bufibvas;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@javax.inject.Named(value = "busLineEditorController")
@javax.enterprise.context.SessionScoped
public class BusLineEditorController implements Serializable {
    @Inject
    private BusStopList busStopList;
    @Inject
    private BusLineList busLineList;
    private BusLine selectedLine;
    private BusStop selectedStop;
    private String selectedId;
    private String selectedStopName;
    private int travelTimeMinutes;
    private int status = 0;

    public void setSelectedLine(BusLine selectedLine) {
        this.selectedLine = selectedLine;
    }
    public BusLine getSelectedLine() {
        return selectedLine;
    }
    public ArrayList<BusStop> getBusStopList() {
        return busStopList.getBusStopList();
    }
    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }
    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }
    public void setSelectedStop(BusStop selectedStop) {
        this.selectedStop = selectedStop;
    }
    public BusStop getSelectedStop() {
        return selectedStop;
    }
    public int getStatus() {
        return status;
    }
    public String setStatus(int status) throws IOException {
        this.status = status;
        this.selectedLine = busLineList.getBusLineList().stream()
                .filter(bl -> String.valueOf(bl.getId()).equals(selectedId))
                .findFirst().orElse(null);
        return "buslineeditor?faces-redirect=true";
    }
    public String getSelectedId() {
        return selectedId;
    }
    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }
    public String getSelectedStopName() {
        return selectedStopName;
    }
    public void setSelectedStopName(String selectedStopName) {
        this.selectedStopName = selectedStopName;
    }

    public String addBusStop() throws IOException {
        selectedStop = busStopList.getBusStopList().stream()
                .filter(bl -> String.valueOf(bl.getName()).equals(selectedStopName))
                .findFirst().orElse(null);
        selectedLine.addStop(selectedStop, travelTimeMinutes);
        return "buslineeditor?faces-redirect=true";
    }

    public void removeBusStop(BusStop busStop) throws IOException {
        if (selectedLine == null) return;
        busStopList.removeBusStop(busStop);
        FacesContext.getCurrentInstance().getExternalContext().redirect("buslineeditor.xhtml");
    }

    public ArrayList<BusLine> getBusLineList() {
        return busLineList.getBusLineList();
    }

    public String mapImgToStop(BusStop busStop) {
        int idx = selectedLine.getStopList().indexOf(busStop);
        if (idx == 0) return "resources/img/start.png";
        if (idx == selectedLine.getStopList().size()-1) return "resources/img/end.png";
        return "resources/img/stop.png";
    }
}
