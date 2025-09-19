package com.bufibvas.bufibvas;

import java.util.ArrayList;

public class BusLineList {
    ArrayList<BusLine> busLineList;
    public BusLineList() {
        busLineList = new ArrayList<>();
        busLineList.add(new BusLine("42"));
        busLineList.add(new BusLine("61"));
        busLineList.add(new BusLine("85"));
        busLineList.add(new BusLine("7"));
        busLineList.add(new BusLine("12"));
    }
}
