package com.hailm.game.model;

import java.awt.Graphics2D;

public abstract class GameObject {
    public static final int SIZE = 50;

    protected int x;

    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D graphics2d);
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
