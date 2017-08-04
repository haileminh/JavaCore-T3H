package com.hailm.giaodien2;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MyContainer extends BasePanel {
    private SView sView;

    private MouseAdapter mouseAdapter;

    private MouseMotionListener mouseMotionListener;

    private boolean canDrag = false;

    private Random rd;

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
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                X = e.getX();
                Y = e.getY();
                sView.setLocation(X, Y);
                int r = rd.nextInt(255);
                int g = rd.nextInt(255);
                int b = rd.nextInt(255);

                Color ramdomColor = new Color(r, g, b);
                sView.setBackground(ramdomColor);
            }
        };
        mouseMotionListener = new MouseMotionListener() {
            
            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                sView.setLocation(e.getX(), e.getY());
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseMotionListener);
        setFocusable(true);
    }

    @Override
    public void addComponents() {
        sView = new SView();
        add(sView);
    }

}
