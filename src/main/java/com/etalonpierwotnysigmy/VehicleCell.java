package com.etalonpierwotnysigmy;

abstract class VehicleCell extends Cell{
    protected Position direction;
    protected int speed;

    @Override
    Position update(Position position, Cell[][] grid, int step) {
        if (step % speed == 0) {
            Position newPosition = Position.addPositions(position, direction);
            if (grid[newPosition.x][newPosition.y] == null) return newPosition;
        }
        return position;
    }
}
