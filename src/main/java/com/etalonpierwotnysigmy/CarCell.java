package com.etalonpierwotnysigmy;

public class CarCell extends VehicleCell {

    public CarCell(Position direction) {
        super(direction);
        speed = 1;
    }

    @Override
    public String toString() {
        return "c";
    }
}
