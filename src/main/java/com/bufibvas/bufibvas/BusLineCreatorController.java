package com.bufibvas.bufibvas;

import javax.inject.Inject;
import java.io.Serializable;

@javax.inject.Named(value = "busLineCreatorController")
@javax.enterprise.context.RequestScoped
public class BusLineCreatorController implements Serializable {
    @Inject
    private BusLineList busLineList;
    private String linenum;
    private String workinghrs;
    private boolean firstLoad = false;

    public void createBusLine() {
        BusLine line = new BusLine(linenum, workinghrs);
        busLineList.addBusLine(line);
    }
    public void clear() {
        linenum = null;
        workinghrs = null;
        firstLoad = false;
    }

    public String getLinenum() {
        return linenum;
    }
    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }
    public String getWorkinghrs() {
        return workinghrs;
    }
    public void setWorkinghrs(String workinghrs) {
        this.workinghrs = workinghrs;
    }
}
