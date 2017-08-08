package com.hailm.giaodien;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class Gui extends JFrame implements SetUp{
    
    public static final int WIDTH_FRAME = 800;
    public static final int HEIGHT_FRAME = 500;
    private MyPanel myPanel;
    public Gui() {
        initComponents();
        addComponents();
        registerListener();
    }
    
    @Override
    public void initComponents() {
      
        setTitle("Test giao dien b2"); // set title
        
        setResizable(true);             // set co dan khung
        setLayout(new CardLayout());    // set cardLayout fillParents
        setSize(WIDTH_FRAME, HEIGHT_FRAME); // set size
        setLocationRelativeTo(null);            // hien thi giữa màn hình
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    @Override
    public void addComponents() {
        myPanel = new MyPanel();
        add(myPanel);
    }

    @Override
    public void registerListener() {
        // TODO Auto-generated method stub
        
    }
    
}
