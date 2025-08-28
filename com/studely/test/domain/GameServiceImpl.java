package com.studely.test.domain;


import com.studely.test.entity.Cell;
import com.studely.test.entity.Grid;
import com.studely.test.infrastructure.persistence.repository.GameService;

public class GameServiceImpl implements GameService {

    public void nextGeneration(Grid grid) {
        Cell[][] newCells = new Cell[grid.getRows()][grid.getCols()];
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                newCells[i][j] = new Cell(grid.getCells()[i][j].isAlive());
                int neighbors = countNeighbors(grid, i, j);
                if (grid.getCells()[i][j].isAlive()) {
                    newCells[i][j].setAlive(neighbors == 2 || neighbors == 3);
                } else {
                    newCells[i][j].setAlive(neighbors == 3);
                }
            }
        }
        grid.setCells(newCells);
    }

    private int countNeighbors(Grid grid, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < grid.getRows() && newY >= 0 && newY < grid.getCols()) {
                    count += grid.getCells()[newX][newY].isAlive() ? 1 : 0;
                }
            }
        }
        return count;
    }
}