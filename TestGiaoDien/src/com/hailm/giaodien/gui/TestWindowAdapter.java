package com.hailm.giaodien.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowAdapter {
    private WindowAdapter windowAdapter = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // TODO Auto-generated method stub
            super.windowClosing(e);
        }
        
    };
}
