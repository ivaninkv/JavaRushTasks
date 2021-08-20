package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;

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
            return Color.WHITE;
        } else {
            int pow = (int) (Math.log(value) / Math.log(2)) + 1;
            return Color.values()[pow];
        }
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        }
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

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case UP:
                moveUp();
                drawScene();
                break;
            case DOWN:
                moveDown();
                drawScene();
                break;
            case LEFT:
                moveLeft();
                drawScene();
                break;
            case RIGHT:
                moveRight();
                drawScene();
                break;
            default:
                break;
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveLeft() {
        boolean stepDone = false;
        for (int[] ints : gameField) {
            stepDone = stepDone | compressRow(ints);
            stepDone = stepDone | mergeRow(ints);
            if (stepDone) {
                compressRow(ints);
            }
        }

        if (stepDone) {
            createNewNumber();
        }
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] tmp = new int[SIDE][SIDE];
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                tmp[y][SIDE - x - 1] = gameField[x][y];
            }
        }
        gameField = tmp;
    }

    private int getMaxTileValue() {
        int maxValue = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                maxValue = Math.max(maxValue, gameField[x][y]);
            }
        }

        return maxValue;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.GREEN, 36);
    }

    private boolean canUserMove() {
        boolean canUserMove = false;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] == 0) {
                    canUserMove = true;
                    break;
                }
            }
            if (canUserMove) {
                break;
            }
        }
        if (!canUserMove) {
            for (int y = 1; y < SIDE; y++) {
                for (int x = 1; x < SIDE; x++) {
                    if (gameField[y][x] == gameField[y - 1][x] ||
                            gameField[y][x] == gameField[y][x - 1] ||
                            gameField[y - 1][x - 1] == gameField[y][x - 1] ||
                            gameField[y - 1][x - 1] == gameField[y - 1][x]) {
                        canUserMove = true;
                        break;
                    }
                }
                if (canUserMove) {
                    break;
                }
            }
        }
        return canUserMove;
    }
}
