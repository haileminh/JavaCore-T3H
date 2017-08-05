package com.hailm.giaodien.ui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame implements SetUp {

    private static final int WIDTH_FRAME = 800;

    private static final int HEIGHT_FRAME = 600;

    private WindowAdapter windowAdapter;
    private MyContainer myContainer;

    public GUI() {
        initComponents();
        registerListener();
        addComponents();
    }

    @Override
    public void initComponents() {
        setTitle("Test giao dien.");
        setLayout(new CardLayout()); // fillParent
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setResizable(false);// Co dan frame
        // Vị trí
        // int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
        // int heightScreen =
        // Toolkit.getDefaultToolkit().getScreenSize().height;
        //
        // setLocation((widthScreen - WIDTH_FRAME) / 2,
        // (heightScreen - HEIGHT_FRAME) / 2);

        setLocationRelativeTo(null);//
        // DO_NO_THING_ON_CLOSE
        // HIDE_ONE_CLOSE
        // EXIT_ON_CLOSE
        // DISPOSE_ON_CLOSE : TH 2 jrame trở lên, tắt Frame hiện tại

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void registerListener() {
        windowAdapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Do you want to exits", "Exits",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        addWindowListener(windowAdapter);
    }

    @Override
    public void addComponents() {
        myContainer = new MyContainer();
        add(myContainer);
    }

}
