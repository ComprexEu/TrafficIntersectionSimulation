package com.etalonpierwotnysigmy;

public class BikeCell extends VehicleCell{
    public BikeCell(Position direction) {
        super(direction);
        speed = 3;
    }
    @Override
    public String toString() {
        return "b";
    }
}
