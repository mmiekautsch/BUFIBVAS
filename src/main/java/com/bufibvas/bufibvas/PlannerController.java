package com.bufibvas.bufibvas;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

@javax.inject.Named(value = "plannerController")
@javax.enterprise.context.SessionScoped
public class PlannerController implements Serializable {
    @Inject
    private BusLineList busLineList;

    private int status;
    private BusLine selectedLine;

    public PlannerController() {
        status = 0;
    }

    public BusLine getSelectedLine() {
        return selectedLine;
    }
    public void setSelectedLine(BusLine selectedLine) {
        this.selectedLine = selectedLine;
        status = 1;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) throws IOException {
        this.status = status;
        FacesContext.getCurrentInstance().getExternalContext().redirect("planner.xhtml");
    }
    public void clear() {
        selectedLine = null;
        status = 0;
    }
    public void deleteLine(BusLine line) throws IOException {
        busLineList.removeBusLine(line);
        FacesContext.getCurrentInstance().getExternalContext().redirect("planner.xhtml");
    }
    public ArrayList<BusLine> getBusLines() {
        return busLineList.getBusLineList();
    }
}
