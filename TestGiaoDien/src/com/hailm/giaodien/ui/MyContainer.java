package com.hailm.giaodien.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MyContainer extends BasePanel {
    private Random rd;

    private SView sView;

    private KeyAdapter keyAdapter;

    private MouseAdapter mouseAdapter;

    private MouseMotionListener mouseMotionListener;

    private int X, Y;

    public MyContainer() {
        rd = new Random();
    }

    @Override
    public void initComponents() {
        setLayout(null);
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
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    setBackground(Color.GRAY);
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

            @Override
            public void mouseClicked(MouseEvent e) {
                X = e.getX();
                Y = e.getY();
                sView.setLocation(X, Y);

                int r = rd.nextInt(255);
                int g = rd.nextInt(255);
                int b = rd.nextInt(255);
                Color randomColor = new Color(r, g, b);
                sView.setBackground(randomColor);
            }
        };
        mouseMotionListener = new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseDragged(MouseEvent arg0) {
                sView.setLocation(arg0.getX(), arg0.getY());
            }
            
        };
        setFocusable(true);
        addKeyListener(keyAdapter);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseMotionListener);
    }

    @Override
    public void addComponents() {
        sView = new SView();
        add(sView);
    }

}
