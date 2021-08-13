package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private static final Color defaultColor = Color.ORANGE;
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, defaultColor);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                List<GameObject> neighbors = getNeighbors(gameField[j][i]);
                int mines = 0;
                for (GameObject go : neighbors) {
                    if (go.isMine) {
                        mines++;
                    }
                }
                if (!gameField[j][i].isMine) {
                    gameField[j][i].countMineNeighbors = mines;
                }
            }
        }
    }

    private void openTile(int x, int y) {
        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped) {
            return;
        }
        gameField[y][x].isOpen = true;
        setCellColor(x, y, Color.GREEN);
        countClosedTiles--;
        if (gameField[y][x].isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            if (gameField[y][x].countMineNeighbors == 0) {
                List<GameObject> neighbors = getNeighbors(gameField[y][x]);
                for (GameObject go : neighbors) {
                    if (!go.isOpen) {
                        openTile(go.x, go.y);
                    }
                }
                setCellValue(x, y, "");
            }
            score += 5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) {
                win();
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped){
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void markTile(int x, int y) {
        GameObject go = gameField[y][x];
        if (!go.isOpen && (countFlags != 0 || go.isFlag) && !isGameStopped) {
            if (!go.isFlag) {
                go.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            } else {
                go.isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, defaultColor);
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "Game Over!", Color.RED, 36);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You Win!", Color.GREEN, 36);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }
}
