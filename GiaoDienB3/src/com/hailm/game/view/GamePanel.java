package com.hailm.game.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.hailm.game.manager.GameManager;

public class GamePanel extends BasePanel implements Runnable{
    private GameManager gameManager;

    @Override
    public void initComponents() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    @Override
    public void addComponents() {
        gameManager = new GameManager();
        
       startGame();
    }

    @Override
    public void registerListener() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x =  e.getX();
                int y = e.getY();
                gameManager.handleClickEvent(x, y);
            }
        };
        addMouseListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g;

        gameManager.drawBallons(graphics2d);
        // drawDemo(graphics2d);
    }
    private void startGame(){
        Thread thread = new Thread(this);
        thread.start();
        
    }
    @Override
    public void run() {
        while (true) {
            gameManager.moveBalloons();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private void drawDemo(Graphics2D graphics2d) {

        graphics2d.setColor(Color.MAGENTA);
        graphics2d.setStroke(new BasicStroke(8));

        // RenderingHints đỡ răng cưa
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.drawLine(10, 10, 100, 100);

        graphics2d.drawOval(200, 200, 200, 200);

        graphics2d.setColor(Color.RED);
        //
        graphics2d.fillOval(200, 200, 100, 100);

        graphics2d.drawArc(300, 50, 100, 100, 50, 100);

        graphics2d.fillArc(400, 100, 100, 100, 0, 80);
        graphics2d.setColor(Color.GRAY);
        graphics2d.setFont(new Font("Arial", Font.BOLD, 28));
        graphics2d.drawString("Lê Minh Hải", 250, 100);
    }

 
   
}
