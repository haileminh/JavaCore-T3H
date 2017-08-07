package com.hailm.ransanmoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameScreenPanel extends BasePanel {

    public static final int A = 35;

    public static final int B = 25;

    static int arrBg[][];

    static int padding = 10;

    static int WIDTH = 700;

    static int HEIGHT = 500;

    static boolean isPlaying = false;
    static boolean isGameOver = false;

    static boolean enableTextStartGame = true;

    private ConRan conRan;

    private KeyAdapter keyAdapter;

    Thread thread;

    public int[][] getArrBg() {
        return arrBg;
    }

    public void setArrBg(int[][] arrBg) {
        this.arrBg = arrBg;
    }

    public GameScreenPanel() {
        conRan = new ConRan();
        Data.loadImage();
        Data.loadAllAnim();

        arrBg = new int[A][B];

        arrBg[10][10] = 2; // kT con ran

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        long t = 0;
        long t2 = 0;
        while (true) {
            if (System.currentTimeMillis() - t2 > 500) {
                enableTextStartGame =! enableTextStartGame;
                t2 = System.currentTimeMillis();
            }
            if (isPlaying) {
                if (System.currentTimeMillis() - t > 200) {
                    Data.worm.update();
                    t = System.currentTimeMillis();
                }
                conRan.updateConRan();
            }

            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // g.setColor(Color.WHITE);
        // g.fillRect(0, 0,800, 600);
        // g.setColor(Color.BLUE);
        // g.fillRect(a, 10, 50, 50);
        // g.drawString("Hello", 50, a);
        paintBg(g);
        conRan.paintConRan(g);
        paintKhung(g);

        if (!isPlaying) {
            if (enableTextStartGame) {
                g.setColor(Color.BLACK);
                g.setFont(g.getFont().deriveFont(18.0f));
                g.drawString("PRESS SPACE TO PLAY GAME...", 250, 250);
            }
        }
        if (isGameOver) {
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(28.0f));
            g.drawString("GAME OVER!!!", 250, 300);
        }
    }

    private void paintKhung(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawRect(0, 0, WIDTH + padding * 2, HEIGHT + padding * 2);
    }

    private void paintBg(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH + padding * 2, HEIGHT + padding * 2);
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {

                // g.fillRect(i * 20, j * 20, 19, 19);

                if (arrBg[i][j] == 2) {
                    g.setColor(Color.RED);
                    // g.fillRect(i * 20, j * 20, 19, 19);
                    g.drawImage(Data.worm.getCurrentImage(),
                            i * 20 - 7 + padding, j * 20 - 7 + padding, null);
                    g.setColor(Color.WHITE);
                }
            }
        }
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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isPlaying = !isPlaying;
                    if(isGameOver == true) isGameOver =! isGameOver;
                    conRan.resetGame();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    conRan.setVector(ConRan.GO_UP);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    conRan.setVector(ConRan.GO_DOWN);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    conRan.setVector(ConRan.GO_LEFT);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    conRan.setVector(ConRan.GO_RIGHT);
                }
            }
        };
        setFocusable(true);
        addKeyListener(keyAdapter);
    }

    @Override
    public void addComponents() {
        // TODO
    }

}
