package com.hailm.drawing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hailm.drawing.model.Bombay;

public class MyPanel extends BasePanel {
    public static boolean IS_RUNNING = false;

    private Bombay bombay;

    private Bombay bombay2;

    private KeyListener keyListener;

    private boolean flagLeft;

    private boolean flagRight;

    private boolean flagUp;

    private boolean flagDown;

    private boolean flagFire;

    private Runnable runnable;

    private Thread thead;

    @Override
    public void initComponents() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    @Override
    public void addComponents() {
        bombay = new Bombay(100, 100, 100, Bombay.LEFT, Color.RED);
        bombay2 = new Bombay(500, 300, 100, Bombay.RIGHT, Color.BLUE);
        runnable = new Runnable() {

            @Override
            public void run() {
                executeActions();
            }
        };
        thead = new Thread(runnable);
        IS_RUNNING = true;
        thead.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        bombay.draw(g2d);
        bombay2.draw(g2d);
    }

    @Override
    public void registerListener() {
        keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                doKeyListener(e, false);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                doKeyListener(e, true);
            }
        };

        setFocusable(true);
        addKeyListener(keyListener);
    }

    protected void doKeyListener(KeyEvent e, boolean value) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
        case KeyEvent.VK_LEFT:
            flagLeft = value;
            break;
        case KeyEvent.VK_RIGHT:
            flagRight = value;
            break;
        case KeyEvent.VK_UP:
            flagUp = value;
            break;
        case KeyEvent.VK_DOWN:
            flagDown = value;
            break;
        case KeyEvent.VK_SPACE:
            flagFire = value;
            break;
        default:
            break;
        }
    }

    protected void executeActions() {
        long currentTime = 0;

        while (IS_RUNNING) {
            if (flagFire) {
                if (System.currentTimeMillis() > currentTime + 500) {
                    bombay.fire();
                    currentTime = System.currentTimeMillis();
                }
            }

            if (flagLeft) {
                bombay.changeOrient(Bombay.LEFT);
                if (!bombay.isCollision(-10, 0, bombay2.getRect())) {
                    bombay.move();
                } else {
                    bombay.move();
                    bombay2.changeOrient(Bombay.LEFT);
                    bombay2.move();
                }
                repaint();
            }
            if (flagRight) {
                bombay.changeOrient(Bombay.RIGHT);
                if (!bombay.isCollision(0, 10, bombay2.getRect())) {
                    bombay.move();
                } else {
                    bombay.move();
                    bombay2.changeOrient(Bombay.RIGHT);
                    bombay2.move();
                }
                repaint();
            }
            if (flagUp) {
                bombay.changeOrient(Bombay.UP);
                if (!bombay.isCollision(0, -10, bombay2.getRect())) {
                    bombay.move();
                } else {
                    bombay.move();
                    bombay2.changeOrient(Bombay.UP);
                    bombay2.move();
                }
                repaint();
            }
            if (flagDown) {
                bombay.changeOrient(Bombay.DOWN);
                if (!bombay.isCollision(-10, 0, bombay2.getRect())) {
                    bombay.move();
                } else {
                    bombay.move();
                    bombay2.changeOrient(Bombay.DOWN);
                    bombay2.move();
                }
                repaint();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bombay2.bigger(bombay.getListBuller());
            bombay.moveBullet();
            repaint();
        }
    }

}
