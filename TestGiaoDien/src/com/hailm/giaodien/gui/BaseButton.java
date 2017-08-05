package com.hailm.giaodien.gui;

import javax.swing.JButton;

public abstract class BaseButton extends JButton implements SetUp{
    public BaseButton(){
        initComponents();
        registerListener();
        addComponents();
    }
}
