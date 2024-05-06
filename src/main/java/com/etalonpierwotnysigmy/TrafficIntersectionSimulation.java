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

    public void initializeGrid() {
        for (int i = grid.length / 2 - 1; i <= grid.length / 2; i++) {
            for (int j = 0 / 2; j < grid.length; j++) {
                chooseCellType(i, j);
            }
        }
        for (int i = 0; i <= grid.length / 2 - 2; i++) {
            for (int j = grid.length / 2 - 1; j <= grid.length / 2 ; j++) {
                chooseCellType(i, j);
            }
        }
        for (int i = grid.length / 2 + 1; i < grid.length; i++) {
            for (int j = grid.length / 2 - 1; j <= grid.length / 2 ; j++) {
                chooseCellType(i, j);
            }
        }

    }

    private void chooseCellType(int i, int j) {
        double randomProbability = Math.random();
        double carProbability = (double)carWeight / totalWeight;
        double truckProbability = (double)truckWeight / totalWeight;
        double bikeProbability = (double)bikeWeight / totalWeight;

        if (randomProbability < carProbability) grid[i][j] = new CarCell();
        else if (randomProbability < carProbability + truckProbability) grid[i][j] = new TruckCell();
        else if (randomProbability < carProbability + truckProbability + bikeProbability) grid[i][j] = new BikeCell();
    }

    public void updateGrid() {

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
