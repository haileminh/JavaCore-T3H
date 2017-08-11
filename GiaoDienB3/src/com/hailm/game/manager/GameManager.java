package com.hailm.game.manager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hailm.game.model.Balloon;
import com.hailm.game.model.GameObject;
import com.hailm.game.view.Gui;

public class GameManager {
    private List<Balloon> balloons;

    public GameManager() {
        balloons = new ArrayList<>();
        initializeBalloons();
    }

    private void initializeBalloons() {
        Random rd = new Random();
        for (int i = 0; i < 30; i++) {
            int x = rd.nextInt(Gui.WIDTH_FRAME - GameObject.SIZE);
            int y = Gui.HEIGHT_FRAME + rd.nextInt(512);
            int type = rd.nextInt(2);

            Balloon balloon = new Balloon(x, y, type);
            balloons.add(balloon);

        }
    }

    public void drawBallons(Graphics2D graphics2d) {
        for (int i = 0; i < balloons.size(); i++) {
            balloons.get(i).draw(graphics2d);
        }
    }

    public void moveBalloons() {
        for (int i = 0; i < balloons.size(); i++) {
            balloons.get(i).move();
        }
    }

    public void handleClickEvent(int x, int y) {
        for (int i = 0; i < balloons.size(); i++) {
            if (isInnerBallon(balloons.get(i), x, y)) {
                balloons.remove(i);
                return;
            }
        }
    }

    private boolean isInnerBallon(Balloon balloon, int x, int y) {
        int delta = GameObject.SIZE/4;
        if (balloon.getX() <= x
                && x<= balloon.getX() + GameObject.SIZE/3*4
                && balloon.getY() <= y 
                && y<= balloon.getY() + GameObject.SIZE/3*4) {
        return true;
    }
        return false;
    }
}
