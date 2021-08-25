package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();

    public Snake(int x, int y) {
        snakeParts.addAll(Arrays.asList(new GameObject(x, y), new GameObject(x + 1, y), new GameObject(x + 2, y)));
    }
}
