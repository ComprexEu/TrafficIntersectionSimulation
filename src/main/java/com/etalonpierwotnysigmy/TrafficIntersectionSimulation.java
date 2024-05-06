package com.etalonpierwotnysigmy;

public class TrafficIntersectionSimulation {
    Cell[][] grid;

    public TrafficIntersectionSimulation(int gridSize) {
        if (gridSize % 2 == 1 || gridSize < 4) {
            throw new IllegalArgumentException("Rozmiar tablicy powinien być parzysty i większy od 3");
        }
        grid = new Cell[gridSize][gridSize];
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
