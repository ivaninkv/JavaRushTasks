package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код

    @Override
    public void onKeyPress(Key key) {
        int width = getScreenWidth();
        int height = getScreenHeight();
        switch (key) {
            case LEFT:
//                for (int y = 0; y < getScreenHeight(); y++) {
//                    setCellColor(0, y, Color.GREEN);
//                }
                for (int y = 0; y < 3; y++) {
                    setCellColor(0, y, Color.GREEN);
                }
                break;
            case RIGHT:
//                for (int y = 0; y < getScreenHeight(); y++) {
//                    setCellColor(getScreenWidth() - 1, y, Color.GREEN);
//                }
                for (int y = 0; y < 3; y++) {
                    setCellColor(3 - 1, y, Color.GREEN);
                }
                break;
            case UP:
//                for (int x = 0; x < getScreenWidth(); x++) {
//                    setCellColor(x, 0, Color.GREEN);
//                }
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 0, Color.GREEN);
                }
                break;
            case DOWN:
//                for (int x = 0; x < getScreenWidth(); x++) {
//                    setCellColor(x, getScreenHeight() - 1, Color.GREEN);
//                }
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, 3 - 1, Color.GREEN);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case LEFT:
            case RIGHT:
            case UP:
            case DOWN:
                for (int y = 0; y < getScreenHeight(); y++) {
                    for (int x = 0; x < getScreenWidth(); x++) {
                        setCellColor(x, y, Color.WHITE);
                    }
                }
                break;
            default:
                break;
        }
    }
}
