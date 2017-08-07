package com.hailm.ransanmoi;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Data {
    public static BufferedImage sprite;

    public static Image imageHead;

    public static Image imageHead_GoLeft;

    public static Image imageHead_GoRight;

    public static Image imageHead_GoUp;

    public static Image imageHead_Go_Down;

    public static Image imageBody;

    public static Image imageWorm;

    public static Image imageWorm2;

    public static Image imageWorm3;

    public static Animation headGoUp;

    public static Animation headGoDown;

    public static Animation headGoLeft;

    public static Animation headGoRight;

    public static Animation worm;

    public static void loadImage() {
        try {
            sprite = ImageIO.read(new File("res/sprite1.png"));

            imageHead = sprite.getSubimage(2, 3, 30, 30);
            imageBody = sprite.getSubimage(7, 79, 20, 20);

            imageHead_GoLeft = sprite.getSubimage(75, 3, 30, 30);
            imageHead_GoRight = sprite.getSubimage(110, 3, 30, 30);
            imageHead_GoUp = sprite.getSubimage(145, 3, 30, 30);
            imageHead_Go_Down = sprite.getSubimage(39, 3, 30, 30);

            imageWorm = sprite.getSubimage(2, 40, 30, 30);
            imageWorm2 = sprite.getSubimage(32, 40, 30, 30);
            imageWorm3 = sprite.getSubimage(63, 40, 30, 30);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadAllAnim() {
        headGoUp = new Animation();
        headGoUp.addImage(imageHead);
        headGoUp.addImage(imageHead_GoUp);

        headGoDown = new Animation();
        headGoDown.addImage(imageHead);
        headGoDown.addImage(imageHead_Go_Down);

        headGoLeft = new Animation();
        headGoLeft.addImage(imageHead);
        headGoLeft.addImage(imageHead_GoLeft);

        headGoRight = new Animation();
        headGoRight.addImage(imageHead);
        headGoRight.addImage(imageHead_GoRight);

        worm = new Animation();
        worm.addImage(imageWorm);
        worm.addImage(imageWorm2);
        worm.addImage(imageWorm3);
    }
}
