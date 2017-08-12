package com.hailm.drawing.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hailm.drawing.view.Gui;

public class Bombay {
    public static final int LEFT = 0;

    public static final int RIGHT = 1;

    public static final int UP = 2;

    public static final int DOWN = 3;

    private int x, y, size, orient;

    private Color color;

    private List<Bombay> listBullet;

    private Random rd;

    public Bombay(int x, int y, int size, int orient, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.orient = orient;
        this.color = color;
        listBullet = new ArrayList<>();
        rd = new Random();
    }

    public void draw(Graphics2D graphics2d) {
        graphics2d.setColor(color);
        graphics2d.fillOval(x, y, size, size);

        for (int i = 0; i < listBullet.size(); i++) {
            listBullet.get(i).draw(graphics2d);
        }

    }

    public boolean move() {
        switch (orient) {
        case LEFT:
            x -= 10;
            if (x < -size) {
                return true;
            }
            break;
        case RIGHT:
            x += 10;
            if (x > Gui.WIDTH_FRAME) {
                return true;
            }
            break;
        case UP:
            y -= 10;
            if (y < -size) {
                return true;
            }
            break;
        case DOWN:
            y += 10;
            if (y > Gui.WIDTH_FRAME) {
                return true;
            }
            break;
        default:
            break;
        }
        return false;
    }

    public boolean isCollision(Rectangle2D rectObj) {
        return isCollision(0, 0, rectObj);
    }

    public boolean isCollision(int i, int j, Rectangle2D rectObj) {
        Rectangle2D dest = new Rectangle();
        Rectangle2D.intersect(getRect(i, j), rectObj, dest);

        double width = dest.getWidth();
        double height = dest.getHeight();

        if (width > 0 && height > 0) {
            return true;

        }
        return false;
    }

    public Rectangle2D getRect() {
        return new Rectangle(x, y, size, size);
    }

    public Rectangle2D getRect(int i, int j) {
        return new Rectangle(x + i, y + j, size, size);
    }

    public void changeOrient(int newOrient) {
        orient = newOrient;
    }

    public void fire() {
        // long time = 0;
        // if (time + 200 > System.currentTimeMillis()) {
        // return;
        // }
        // time = System.currentTimeMillis();

        int sizeBullet = 40;
        int xBullet = x + size / 2 - sizeBullet / 2;
        int yBullet = y + size / 2 - sizeBullet / 2;

        Bombay bullet = new Bombay(xBullet, yBullet, sizeBullet, orient,
                Color.MAGENTA);
        listBullet.add(bullet);

    }

    public void moveBullet() {
        for (int i = 0; i < listBullet.size(); i++) {
            boolean isOUt = listBullet.get(i).move();
            if (isOUt) {
                listBullet.remove(i);
                i--;
            }
        }
    }

    public void bigger(List<Bombay> listBuller) {
        for (int i = 0; i < listBuller.size(); i++) {
            if (listBuller.get(i).isCollision(getRect())) {
                size += 5;
                listBuller.remove(i);
                i--;
                randomColor();
            }
        }
    }

    public void randomColor() {
        color = new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));
    }

    public List<Bombay> getListBuller() {
        return listBullet;
    }

}
