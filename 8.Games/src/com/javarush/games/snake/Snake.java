package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private Direction direction = Direction.LEFT;

    public boolean isAlive = true;


    public Snake(int x, int y) {
        snakeParts.addAll(Arrays.asList(new GameObject(x, y), new GameObject(x + 1, y), new GameObject(x + 2, y)));
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            String symbol = i == 0 ? HEAD_SIGN : BODY_SIGN;
            GameObject gameObject = snakeParts.get(i);
            Color snakeColor = isAlive ? Color.DARKORCHID : Color.RED;
            game.setCellValueEx(gameObject.x, gameObject.y, Color.NONE, symbol, snakeColor, 75);

        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){

    }
}