package com.hailm.ransanmoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class ConRan {
    private int doDai = 3;

    int x[];

    int y[];

    public static final int GO_UP = 1;

    public static final int GO_DOWN = -1;

    public static final int GO_LEFT = 2;

    public static final int GO_RIGHT = -2;

    private int vector = ConRan.GO_DOWN;

    private Random rd;

    private long beginTime = 0;

    private long beginTime2 = 0;
    
    private int speed = 200;
    
    private int maxLen = 5;
    

    private int X = GameScreenPanel.A;

    private int Y = GameScreenPanel.B;

    public ConRan() {
        x = new int[X];
        y = new int[Y];

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

    public void resetGame(){
        x = new int[X];
        y = new int[Y];

        x[0] = 9;
        y[0] = 9;

        x[1] = 9;
        y[1] = 8;

        x[2] = 9;
        y[2] = 7;

        doDai = 3;
    }
    public Point layToaDoMoi() {
        rd = new Random();
        int x;
        int y;
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
        if (doDai == maxLen) {
            GameScreenPanel.isPlaying = false;
            resetGame();
            speed = (int) (speed * 0.8);
        }
        
        for (int i = 1; i < doDai; i++) {
            if (x[0] == x[i] && y[0]== y[i]) {
                GameScreenPanel.isPlaying = false;
                GameScreenPanel.isGameOver = true;
            }
        }
        
        if (System.currentTimeMillis() - beginTime2 > 200) {
            Data.headGoUp.update();
            Data.headGoDown.update();
            Data.headGoLeft.update();
            Data.headGoRight.update();

            beginTime2 = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - beginTime > speed) {

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
        g.setColor(Color.red);
        for (int i = 1; i < doDai; i++)
            g.drawImage(Data.imageBody, x[i] * 20 + GameScreenPanel.padding,
                    y[i] * 20 + GameScreenPanel.padding, null);
        if (vector == ConRan.GO_UP)
            g.drawImage(Data.headGoUp.getCurrentImage(),
                    x[0] * 20 - 6 + GameScreenPanel.padding,
                    y[0] * 20 - 6 + GameScreenPanel.padding, null);
        else if (vector == ConRan.GO_DOWN)
            g.drawImage(Data.headGoDown.getCurrentImage(),
                    x[0] * 20 - 6 + GameScreenPanel.padding,
                    y[0] * 20 - 6 + GameScreenPanel.padding, null);
        else if (vector == ConRan.GO_RIGHT)
            g.drawImage(Data.headGoRight.getCurrentImage(),
                    x[0] * 20 - 6 + GameScreenPanel.padding,
                    y[0] * 20 - 6 + GameScreenPanel.padding, null);
        else if (vector == ConRan.GO_LEFT)
            g.drawImage(Data.headGoLeft.getCurrentImage(),
                    x[0] * 20 - 6 + GameScreenPanel.padding,
                    y[0] * 20 - 6 + GameScreenPanel.padding, null);

    }
}
