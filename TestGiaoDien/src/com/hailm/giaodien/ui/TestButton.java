package com.hailm.giaodien.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hailm.giaodien.gui.Button1;

public class TestButton extends BaseButton{
   
    @Override
    public void initComponents() {
       setText("Test Button");
       setSize(100, 100);
       setBackground(Color.CYAN);
    }

    @Override
    public void registerListener() {
        addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TestButton.this,
                        "Button hello da duoc kich");
               
            }
        });
    }

    @Override
    public void addComponents() {
        // TODO Auto-generated method stub
        
    }

}
