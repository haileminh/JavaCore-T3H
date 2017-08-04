package com.hailm.giaodien1;

import javax.swing.JPanel;

public abstract class BasePanel extends JPanel implements SetUp {

    public BasePanel() {
        initComponents();
        registerListener();
        addComponents();
    }
}
