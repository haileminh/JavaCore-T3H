package com.hailm.giaodien1;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class GUI extends JFrame implements SetUp {

    private static final int HEIGHT_FRAME = 400;
    private static final int WIDTH_FRAME = 800;
    private MyContainer myContainer;

    public GUI() {
        initComponents();
        registerListener();
        addComponents();
    }

    @Override
    public void initComponents() {
        setTitle("Bài tập giao diện 1.");
        setLayout(new CardLayout());
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComponents() {
        myContainer = new MyContainer();
        add(myContainer);
    }

}
