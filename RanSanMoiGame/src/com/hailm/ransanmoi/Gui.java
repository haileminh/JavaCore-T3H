package com.hailm.ransanmoi;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui extends JFrame implements SetUp {
    public static final int WIDTH_FRAME = 1200;

    public static final int HEIGHT_FRAME = 600;

    private WindowAdapter windowAdapter;

    private GameScreenPanel gameScreen;

    public Gui() {
        initComponents();
        registerListener();
        addComponents();
    }

    @Override
    public void initComponents() {
        setTitle("Test game");
        setLayout(new CardLayout());
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setResizable(true);// Co dan frame
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void registerListener() {
        windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Do you want to exits", "Exits",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        addWindowListener(windowAdapter);
    }

    @Override
    public void addComponents() {
        gameScreen = new GameScreenPanel();
        add(gameScreen);
    }

}
