package com.studely.test.userinterface;

import com.studely.test.entity.Cell;
import com.studely.test.entity.Grid;


public class ConsoleDisplay {
    public void display(Grid grid) {
        Cell[][] cells = grid.getCells();
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                System.out.print(cells[i][j].isAlive() ? "X " : "O ");
            }
            System.out.println();
        }
        System.out.println();
    }
}