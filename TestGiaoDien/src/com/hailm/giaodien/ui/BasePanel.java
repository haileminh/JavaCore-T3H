package com.hailm.giaodien.ui;

import javax.swing.JPanel;

public abstract class BasePanel extends JPanel implements SetUp {

    public BasePanel() {
        initComponents();
        registerListener();
        addComponents();
    }

}
