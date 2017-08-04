package com.hailm.giaodien1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MyContainer extends BasePanel {
    private Random rd;

    KeyAdapter keyAdapter;

    MouseAdapter mouseAdapter;

    public MyContainer() {
        rd = new Random();
    }

    @Override
    public void initComponents() {
        setLayout(new CardLayout());
        setBackground(Color.WHITE);
    }

    @Override
    public void registerListener() {
        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setBackground(Color.YELLOW);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setBackground(Color.RED);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setBackground(Color.BLUE);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setBackground(Color.BLACK);
                }
            }
        };
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               int r = rd.nextInt(255);
               int g = rd.nextInt(255);
               int b = rd.nextInt(255);
               Color ramdomColor = new Color(r, g, b);
               setBackground(ramdomColor);
            }
        };
        setFocusable(true);
        addKeyListener(keyAdapter);
        addMouseListener(mouseAdapter);
    }

    @Override
    public void addComponents() {
        // TODO Auto-generated method stub

    }

}
