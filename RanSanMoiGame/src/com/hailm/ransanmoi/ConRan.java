package com.hailm.ransanmoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class ConRan {
    private int doDai = 3;

    int x[], y[];

    public static final int GO_UP = 1;

    public static final int GO_DOWN = -1;

    public static final int GO_LEFT = 2;

    public static final int GO_RIGHT = -2;

    private int vector = ConRan.GO_DOWN;

    private Random rd;

    long beginTime = 0;

    private int X = GameScreenPanel.A;

    private int Y = GameScreenPanel.B;

    public ConRan() {
        x = new int[X];
        y = new int[20];

        x[0] = 9;
        y[0] = 9;

        x[1] = 9;
        y[1] = 8;

        x[2] = 9;
        y[2] = 7;

    }

    public void setVector(int vector) {
        if (this.vector != -vector)
            this.vector = vector;
    }

    public Point layToaDoMoi() {
        rd = new Random();
        int x, y;
        do {
            x = rd.nextInt(X - 1);
            y = rd.nextInt(Y - 1);
        } while (checkToaDoTrongThanRan(x, y));

        return new Point(x, y);
    }

    private boolean checkToaDoTrongThanRan(int x, int y) {
        boolean flag = false;
        for (int i = 0; i < doDai; i++) {
            if (this.x[i] == x && this.y[i] == y) {
                flag = true;
            } 
        }
        return flag;
    }

    public void updateConRan() {
        if (System.currentTimeMillis() - beginTime > 500) {

            if (GameScreenPanel.arrBg[x[0]][y[0]] == 2) {
                doDai++;
                GameScreenPanel.arrBg[x[0]][y[0]] = 0;
                GameScreenPanel.arrBg[layToaDoMoi().x][layToaDoMoi().y] = 2;
            }

            for (int i = doDai - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            if (vector == ConRan.GO_UP)
                y[0]--;
            if (vector == ConRan.GO_DOWN)
                y[0]++;
            if (vector == ConRan.GO_LEFT)
                x[0]--;
            if (vector == ConRan.GO_RIGHT)
                x[0]++;

            if (x[0] < 0)
                x[0] = X - 1;
            if (x[0] > X - 1)
                x[0] = 0;
            if (y[0] < 0)
                y[0] = Y - 1;
            if (y[0] > Y - 1)
                y[0] = 0;
            beginTime = System.currentTimeMillis();
        }

    }

    public void paintConRan(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0; i < doDai; i++) {
            g.fillRect(x[i] * 20, y[i] * 20, 19, 19);
        }
    }
}
