package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                boolean isMine = getRandomNumber(SIDE + 1) == SIDE / 2;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[i][j] = new GameObject(j, i, isMine);
                setCellColor(j, i, Color.ORANGE);
            }
        }
    }
}
