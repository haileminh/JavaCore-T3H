package com.hailm.giaodien.gui;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui extends JFrame implements SetUp {

    private static final int HEIGHT_FRAME = 600;

    private static final int WIDTH_FRAME = 800;

    private WindowAdapter windowAdapter;
    private RootPanel redPanel;

    public Gui() {
        initComponents();
        registerListener();
        addComponents();
    }

    @Override
    public void initComponents() {
        setTitle("Demo giao dien.");
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
      //  setResizable(false); // setup thay doi co dan frame

        // Vi tri
        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;

        setLocation((widthScreen - WIDTH_FRAME) / 2,
                (heightScreen - HEIGHT_FRAME) / 2);

        // setLocationRelativeTo(null); //
        
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
                // TODO
                int option = JOptionPane.showConfirmDialog(Gui.this,
                        "Do you want to exits", "Exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    // setVisible(false); // HIDE_ONE_CLOSE
                    // dispose(); // DISPOSE_ON_CLOSE
                    System.exit(0);
                }
            }
            
        };
        addWindowListener(windowAdapter);
    }

    @Override
    public void addComponents() {
       redPanel = new RootPanel();
       add(redPanel);
    }

}
