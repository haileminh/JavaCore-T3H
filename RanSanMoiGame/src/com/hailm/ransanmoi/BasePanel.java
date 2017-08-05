package com.hailm.ransanmoi;

import javax.swing.JPanel;

public abstract class BasePanel extends JPanel implements SetUp, Runnable{
    public BasePanel() {
        initComponents();
        registerListener();
        addComponents();
    }
}
