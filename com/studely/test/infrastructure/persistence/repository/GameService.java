package com.studely.test.infrastructure.persistence.repository;

import com.studely.test.entity.Grid;

public interface GameService {

    public void nextGeneration(Grid grid);
}
