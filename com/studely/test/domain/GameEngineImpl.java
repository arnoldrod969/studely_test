package com.studely.test.domain;

import com.studely.test.entity.Grid;
import com.studely.test.infrastructure.persistence.repository.GameEngineService;

public class GameEngineImpl implements GameEngineService {
    private final Grid grid;
    private final GameServiceImpl gameService;

    public GameEngineImpl(Grid grid) {
        this.grid = grid;
        this.gameService = new GameServiceImpl();
    }

    public void run(int generations) {
        for (int i = 0; i < generations; i++) {
            gameService.nextGeneration(grid);
            try {
                Thread.sleep(1000); // Pause de 1 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
