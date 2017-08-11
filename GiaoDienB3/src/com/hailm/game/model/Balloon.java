package com.hailm.game.model;

import java.awt.Graphics2D;

import com.hailm.game.manager.ImageStore;

public class Balloon extends GameObject {

    public static final int TYPE_BALLOON_1 = 0;

    public static final int TYPE_BALLOON_2 = 1;

    private int type;

    public Balloon(int x, int y, int type) {
        super(x, y);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void draw(Graphics2D graphics2d) {
        switch (type) {
        case TYPE_BALLOON_1:
            graphics2d.drawImage(ImageStore.IMG_BALLOON_1, x, y, SIZE, SIZE,
                    null);
            break;
        case TYPE_BALLOON_2:
            graphics2d.drawImage(ImageStore.IMG_BALLOON_2, x, y, SIZE, SIZE,
                    null);
            break;
        default:
            break;
        }
    }

    public void move() {
        y--;
    }
}
