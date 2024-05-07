package com.etalonpierwotnysigmy;

public class TruckCell extends VehicleCell{

    public TruckCell(Position direction) {
        super(direction);
        speed = 2;
    }
    @Override
    public String toString() {
        return "t";
    }
}
