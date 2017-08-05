package com.hailm.giaodien.ui;

import java.awt.Color;

import javax.swing.JPanel;

public class SView extends BasePanel{
    private TestButton testButton;
    @Override
    public void initComponents() {
       setSize(200, 200);
       setBackground(Color.RED);
       setLocation(300, 300);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addComponents() {
        testButton = new TestButton();
        add(testButton);
    }

}
