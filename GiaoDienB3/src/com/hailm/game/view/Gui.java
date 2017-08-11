package com.hailm.game.view;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Gui extends JFrame implements SetUp {

    public static final int WIDTH_FRAME = 800;

    public static final int HEIGHT_FRAME = 500;

    private GamePanel gamePanel;

    public Gui() {
        initComponents();
        addComponents();
        registerListener();
    }

    @Override
    public void initComponents() {
        setTitle("Lập trình đồ họa.");
        setLayout(new CardLayout());
        setResizable(true);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setIconImage(new ImageIcon("images/donald_trump1600.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void addComponents() {
        gamePanel = new GamePanel();
        add(gamePanel);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub

    }

}
