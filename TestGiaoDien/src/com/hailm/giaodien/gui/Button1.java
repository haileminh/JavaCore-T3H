package com.hailm.giaodien.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Button1 extends BaseButton {

    @Override
    public void initComponents() {
        setText("Hello");
        setBackground(Color.BLUE);
    }

    @Override
    public void registerListener() {
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Button1.this,
                        "Button hello da duoc kich");
            }
        });
    }

    @Override
    public void addComponents() {
        // TODO Auto-generated method stub

    }

}
