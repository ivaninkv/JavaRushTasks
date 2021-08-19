package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void drawScene() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String cellValue = value == 0 ? "" : String.valueOf(value);
        setCellValueEx(x, y, color, cellValue);
    }

    private Color getColorByValue(int value) {
        if (value == 0) {
            return Color.values()[value];
        } else {
            int pow = (int) (Math.log(value) / Math.log(2));
            return Color.values()[pow];
        }
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {
        boolean cellFound = false;
        while (!cellFound) {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[y][x] == 0) {
                cellFound = true;
                gameField[y][x] = getRandomNumber(10) == 9 ? 4 : 2;
            }
        }
    }

    private boolean compressRow(int[] row) {
        boolean hasChanges = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > 0 && row[i - 1] == 0) {
                int tmp = row[i - 1];
                row[i - 1] = row[i];
                row[i] = tmp;
                if (!hasChanges) {
                    hasChanges = true;
                }
                i = 0;
            }
        }
        return hasChanges;
    }

    private boolean mergeRow(int[] row) {
        boolean merged = false;

        for (int i = 1; i < row.length; i++) {
            if (row[i - 1] != 0 && row[i - 1] == row[i]) {
                row[i - 1] = row[i - 1] + row[i];
                row[i] = 0;
                merged = true;
            }
        }

        return merged;
    }
}
