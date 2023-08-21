package com.projeto.gameView;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class Logoview extends JFrame {

    private static final int DISPLAY_TIME = 5000;

    public Logoview() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920,1080);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        ImageIcon img = new ImageIcon("C:\\Users\\anamo\\OneDrive\\Imagens\\ImgLogo.jpg");
        JLabel label = new JLabel(img);

        panel.setLayout(null); 

        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int labelWidth = img.getIconWidth();
        int labelHeight = img.getIconHeight();
        int x = (screenSize.width - labelWidth) / 2;
        int y = (screenSize.height - labelHeight) / 2;
        label.setBounds(x, y, labelWidth, labelHeight);

        panel.add(label);
        add(panel);
        setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dispose();
            }
        }, DISPLAY_TIME);
    }

    public static void main(String[] args) {
        new Logoview();
    }
}
