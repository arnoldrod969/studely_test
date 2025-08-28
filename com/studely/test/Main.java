package com.studely.test;

import com.studely.test.entity.Grid;
import com.studely.test.domain.GameEngineImpl;
import com.studely.test.userinterface.ConsoleDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean restart;
        do {
            System.out.print("Entrez le nombre de lignes (appuyez sur Entrée pour 5) : ");
            String inputRows = scanner.nextLine().trim();
            int rows = inputRows.isEmpty() ? 5 : Integer.parseInt(inputRows);

            System.out.print("Entrez le nombre de colonnes (appuyez sur Entrée pour 5) : ");
            String inputCols = scanner.nextLine().trim();
            int cols = inputCols.isEmpty() ? 5 : Integer.parseInt(inputCols);

            Grid grid = new Grid(rows, cols);
            grid.initialize();
            ConsoleDisplay display = new ConsoleDisplay();
            display.display(grid);

            GameEngineImpl engine = new GameEngineImpl(grid);
            engine.run(5);

            System.out.print("Voulez-vous recommencer une partie ? (y/N) : ");
            String response = scanner.nextLine().trim().toLowerCase();
            restart = response.equals("y") || response.equals("yes");

        } while (restart);

        System.out.println("Merci d’avoir joué !");
        scanner.close();
    }
}