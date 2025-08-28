package com.studely.test.entity;

import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private final int rows;
    private final int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public void initialize() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(random.nextBoolean());
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}