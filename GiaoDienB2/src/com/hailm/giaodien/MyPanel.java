package com.hailm.giaodien;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyPanel extends BasePanel implements ActionListener {
    private static final String ACTION_RESOLVE = "action_resolve";

    private JLabel lbTitle;

    private JLabel lbA;

    private JLabel lbB;

    private JLabel lbC;

    private TextField tfA;

    private TextField tfB;

    private TextField tfC;

    private JButton btnResolve;

    @Override
    public void initComponents() {
        setLayout(null);
        setBackground(Color.WHITE);
    }

    @Override
    public void addComponents() {
        Font titleFont = new Font("Arial", Font.BOLD, 32);
        Font textFont = new Font("Arial", Font.PLAIN, 20);

        // Title
        lbTitle = new JLabel("Giải phương trình bậc 2");
        lbTitle.setFont(titleFont);
        int widthTitle = getFontMetrics(titleFont)
                .stringWidth(lbTitle.getText());
        int heightTitle = getFontMetrics(textFont).getHeight();
        lbTitle.setBounds((Gui.WIDTH_FRAME - widthTitle) / 2, 32, widthTitle,
                heightTitle + 12);
        lbTitle.setForeground(new Color(0xff2196f3));
        add(lbTitle);

        // He so a,b,c
        int height = getFontMetrics(textFont).getHeight();

        lbA = new JLabel("Hệ số A:");
        lbA.setFont(textFont);
        int widthA = getFontMetrics(textFont).stringWidth(lbA.getText());
        lbA.setBounds(128, lbTitle.getY() + lbTitle.getHeight() + 32, widthA,
                height);
        lbA.setForeground(Color.BLACK);
        add(lbA);

        lbB = new JLabel("Hệ số B: ");
        lbB.setFont(textFont);
        int widthB = getFontMetrics(textFont).stringWidth(lbB.getText());
        lbB.setBounds(lbA.getX(), lbA.getY() + lbA.getHeight() + 32, widthB,
                height);
        lbB.setForeground(Color.BLACK);
        add(lbB);

        lbC = new JLabel("Hệ số C: ");
        lbC.setFont(textFont);
        int widthC = getFontMetrics(textFont).stringWidth(lbC.getText());
        lbC.setBounds(lbB.getX(), lbB.getY() + lbB.getHeight() + 32, widthC,
                height);
        lbC.setForeground(Color.BLACK);
        add(lbC);

        // Input
        tfA = new TextField();
        tfA.setFont(textFont);
        tfA.setBounds(lbA.getX() + lbA.getWidth() + 16, lbA.getY(), 256,
                lbA.getHeight());
        tfA.setForeground(Color.BLACK);
        add(tfA);

        tfB = new TextField();
        tfB.setFont(textFont);
        tfB.setBounds(lbB.getX() + lbB.getWidth() + 16, lbB.getY(),
                tfA.getWidth(), lbB.getHeight());
        tfB.setForeground(Color.BLACK);
        add(tfB);

        tfC = new TextField();
        tfC.setFont(textFont);
        tfC.setBounds(lbC.getX() + lbC.getWidth() + 16, lbC.getY(),
                tfA.getWidth(), lbC.getHeight());
        tfC.setForeground(Color.BLACK);
        add(tfC);

        // Button
        btnResolve = new JButton("Tính toán");
        btnResolve.setFont(textFont);
        int widthBtnResolve = getFontMetrics(textFont)
                .stringWidth(btnResolve.getText()) + 50;
        int xBtnResolve = tfC.getX() + tfC.getWidth() - widthBtnResolve;
        btnResolve.setBounds(xBtnResolve, tfC.getY() + tfC.getHeight() + 16,
                widthBtnResolve, lbC.getHeight() + 16);
        add(btnResolve);
    }

    @Override
    public void registerListener() {
        btnResolve.setActionCommand(ACTION_RESOLVE);
        btnResolve.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case ACTION_RESOLVE:
            resolve();
            break;

        default:
            break;
        }
    }

    private void resolve() {
        String aStr = tfA.getText();
        String bStr = tfB.getText();
        String cStr = tfC.getText();

        if (aStr.isEmpty() || bStr.isEmpty() || cStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }

        try {
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            int c = Integer.parseInt(cStr);

            String result = PTBac2.giaiPTB2(a, b, c);
            JOptionPane.showMessageDialog(this, result, "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
