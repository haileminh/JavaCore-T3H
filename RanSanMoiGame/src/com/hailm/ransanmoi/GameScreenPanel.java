package com.hailm.ransanmoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class GameScreenPanel extends BasePanel {

    public static final int A = Gui.WIDTH_FRAME / 19;

    public static final int B = Gui.HEIGHT_FRAME / 19;

    static  int arrBg[][];

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

        arrBg = new int[A][B];
        arrBg[5][9] = 1;
        arrBg[8][9] = 2;
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        while (true) {
            conRan.updateConRan();
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

    }

    public void paintBg(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
//                if (arrBg[i][j] == 0)
//                    g.setColor(Color.WHITE);
//                if (arrBg[i][j] == 1)
//                    g.setColor(Color.BLACK);
//                if (arrBg[i][j] == 2)
//                    g.setColor(Color.RED);
                g.fillRect(i * 20, j * 20, 19, 19);
                
                if (arrBg[i][j] == 2) {
                    g.setColor(Color.RED);
                    g.fillRect(i * 20, j * 20, 19, 19);
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
