package com.hailm.giaodien.ui;

import javax.swing.JButton;

public abstract class BaseButton extends JButton implements SetUp {
    public BaseButton() {
        initComponents();
        registerListener();
        addComponents();
    }
}
