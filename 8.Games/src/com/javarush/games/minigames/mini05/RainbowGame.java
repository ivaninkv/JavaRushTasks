package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    //напишите тут ваш код
    private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        for (int y = 0; y < getScreenHeight(); y++) {
            for (int x = 0; x < getScreenWidth(); x++) {
                setCellColor(x, y, colors[y]);
            }
        }
    }
}
