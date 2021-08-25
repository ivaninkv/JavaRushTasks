package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";


    public Snake(int x, int y) {
        snakeParts.addAll(Arrays.asList(new GameObject(x, y), new GameObject(x + 1, y), new GameObject(x + 2, y)));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            String symbol = i == 0 ? HEAD_SIGN : BODY_SIGN;
            game.setCellValue(snakeParts.get(i).x, snakeParts.get(i).y, symbol);

        }
    }
}
