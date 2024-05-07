package com.etalonpierwotnysigmy;

abstract class VehicleCell extends Cell{
    protected Position direction;
    protected int speed;

    public VehicleCell(Position direction) {
        this.direction = direction;
    }
    @Override
    Position update(Position position, Cell[][] grid, int step) {
        if (step % speed == 0) {
            Position newPosition = Position.addPositions(position, direction);
            if (grid[newPosition.x][newPosition.y] == null) return newPosition;
        }
        return position;
    }

    public boolean hasPriority(Position position, Cell[][] grid) {
        // implementacja logiki pierwszeństwa
        return true;
    }

    public Position getDirection() {
        return direction;
    }


}
