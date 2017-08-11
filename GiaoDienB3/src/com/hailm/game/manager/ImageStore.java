package com.hailm.game.manager;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageStore {
    public static final Image IMG_BALLOON_1 = getImage("balloon1.png");

    public static final Image IMG_BALLOON_2 = getImage("balloon2.png");

    private static Image getImage(String name) {

        String path = ImageStore.class.getResource("/res/"+ name).getPath();
        return new ImageIcon(path).getImage();
    }
}
