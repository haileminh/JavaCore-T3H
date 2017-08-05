package com.hailm.giaodien.gui;

import java.awt.Color;

import javax.swing.JButton;

public class RootPanel extends BasePanel {
    private Button1 btn6;
    @Override
    public void initComponents() {
     //   setLayout(new CardLayout());
        setBackground(Color.RED);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComponents() {
        JButton btn1 = new JButton("FlowLayout");
        JButton btn2 = new JButton("Add các control");
        JButton btn3 = new JButton("Trên 1 dòng");
        JButton btn4 = new JButton("Hết chỗ chứa");
        JButton btn5 = new JButton("Thì xuống dòng");
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        btn6 = new Button1();
        add(btn6);
        
    }
}
