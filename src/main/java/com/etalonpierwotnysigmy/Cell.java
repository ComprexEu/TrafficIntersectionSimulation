package com.etalonpierwotnysigmy;

abstract class Cell {
    abstract Position update(Position position, Cell[][] grid, int step);
}
