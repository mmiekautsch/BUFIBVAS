package com.bufibvas.bufibvas;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@javax.inject.Named(value = "busLineCreatorController")
@javax.enterprise.context.RequestScoped
public class BusLineCreatorController implements Serializable {
    @Inject
    private BusLineList busLineList;
    @Inject
    private BusStopList busStopList;
    private String linenum;
    private Date workinghrsStart;
    private Date workinghrsEnd;
    private BusStop firstStop;
    private String firstStopName;
    private boolean firstLoad = true;

    public void createBusLine() {
        BusLine line = new BusLine(linenum, workinghrsStart,  workinghrsEnd, firstStop);
        busLineList.addBusLine(line);
        clear();
    }
    public void clear() {
        linenum = null;
        workinghrsStart = null;
        workinghrsEnd = null;
        firstStop = null;
        firstLoad = false;
    }

    public String getLinenum() {
        return linenum;
    }
    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }
    public boolean getFirstLoad() {
        return firstLoad;
    }
    public void setWorkinghrsStart(Date workinghrsStart) {
        this.workinghrsStart = workinghrsStart;
    }
    public Date getWorkinghrsStart() {
        return workinghrsStart;
    }
    public void setWorkinghrsEnd(Date workinghrsEnd) {
        this.workinghrsEnd = workinghrsEnd;
    }
    public Date getWorkinghrsEnd() {
        return workinghrsEnd;
    }
    public ArrayList<BusStop> getBusStopList() {
        return busStopList.getBusStopList();
    }
    public String getFirstStopName() {
        return firstStopName;
    }
    public void setFirstStopName(String firstStopName) {
        this.firstStopName = firstStopName;
        this.firstStop = busStopList.getBusStopList().stream()
                .filter(bs -> String.valueOf(bs.getName()).equals(firstStopName))
                .findFirst().orElse(null);
    }
}
