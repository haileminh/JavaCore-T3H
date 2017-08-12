package com.hailm.drawing.view;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Gui extends JFrame implements SetUp {
    public static final int WIDTH_FRAME = 800;

    public static final int HEIGHT_FRAME = 500;

    private MyPanel myPanel;

    public Gui() {
        initComponents();
        addEvents();
        addComponents();
        registerListener();
    }

    private void addEvents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MyPanel.IS_RUNNING = false;
            }
        });
    }

    @Override
    public void initComponents() {
        setTitle("Drawing");
        setLayout(new CardLayout());
        setResizable(true);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void addComponents() {
        myPanel = new MyPanel();
        add(myPanel);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub

    }

}
