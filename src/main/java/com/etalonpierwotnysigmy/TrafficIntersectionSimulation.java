package com.etalonpierwotnysigmy;

public class TrafficIntersectionSimulation {
    Cell[][] grid;
    int step;
    int carWeight;
    int truckWeight;
    int bikeWeight;
    int nullWeight;
    int totalWeight;

    public TrafficIntersectionSimulation(int gridSize, int carWeight, int truckWeight, int bikeWeight, int nullWeight) {
        if (gridSize % 2 == 1 || gridSize < 4) {
            throw new IllegalArgumentException("Rozmiar tablicy powinien być parzysty i większy od 3");
        }
        grid = new Cell[gridSize][gridSize];
        this.carWeight = carWeight;
        this.truckWeight = truckWeight;
        this.bikeWeight = bikeWeight;
        this.nullWeight = nullWeight;
        totalWeight = carWeight + truckWeight + bikeWeight + nullWeight;
        initializeGrid();
    }

    public void initializeGrid() { // inicjalizacja mapy
        for (int i = grid.length / 2 - 1; i <= grid.length / 2; i++) {
            for (int j = 0; j < grid.length / 2 - 1; j++) {
                spawnCell(i, j);
            }
        }
        for (int i = grid.length / 2 - 1; i <= grid.length / 2; i++) {
            for (int j = grid.length / 2  + 1; j < grid.length; j++) {
                spawnCell(i, j);
            }
        }
        for (int i = 0; i <= grid.length / 2 - 2; i++) {
            for (int j = grid.length / 2 - 1; j <= grid.length / 2 ; j++) {
                spawnCell(i, j);
            }
        }
        for (int i = grid.length / 2 + 1; i < grid.length; i++) {
            for (int j = grid.length / 2 - 1; j <= grid.length / 2 ; j++) {
                spawnCell(i, j);
            }
        }

    }

    private Position chooseDirection(int i, int j) { // wybór kierunku
        if (i == grid.length / 2 - 1 && j >= grid.length / 2) return Direction.LEFT;
        else if (i == grid.length / 2 && j >= grid.length / 2) return Direction.RIGHT;
        else if (i == grid.length / 2 - 1 && j <= grid.length / 2) return Direction.LEFT;
        else if (i == grid.length / 2 && j <= grid.length / 2) return Direction.RIGHT;
        else if (i <= grid.length / 2 && j == grid.length / 2 - 1) return Direction.DOWN;
        else if (i <= grid.length / 2 && j == grid.length / 2) return Direction.UP;
        else if (i >= grid.length / 2 && j == grid.length / 2 - 1) return Direction.DOWN;
        else return Direction.UP;
    }

    private void spawnCell(int i, int j) {
        double randomProbability = Math.random();
        double carProbability = (double)carWeight / totalWeight;
        double truckProbability = (double)truckWeight / totalWeight;
        double bikeProbability = (double)bikeWeight / totalWeight;

        Position direction = chooseDirection(i, j); // inicjalizacja kierunku

        if (randomProbability < carProbability) grid[i][j] = new CarCell(direction); // wybór typu komórki w zależności od prawdopodobieństw
        else if (randomProbability < carProbability + truckProbability) grid[i][j] = new TruckCell(direction);
        else if (randomProbability < carProbability + truckProbability + bikeProbability) grid[i][j] = new BikeCell(direction);
    }

    public void updateGrid() {

    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
                if (grid[i][j] instanceof VehicleCell) System.out.print(((VehicleCell) grid[i][j]).getDirection().toString());
            }
            System.out.println();
        }
    }
}
