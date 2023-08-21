package com.projeto.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {

    private int arc; // Valor do arco para controlar o arredondamento

    public RoundedTextField(int columns, int arc) {
        super(columns);
        this.arc = arc;
        setOpaque(false); // Deixa o fundo transparente
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Espaçamento interno
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));

        super.paintComponent(g2);
        g2.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded TextField Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1, 10, 10));

            RoundedTextField usernameField = new RoundedTextField(20, 15);
            RoundedTextField emailField = new RoundedTextField(20, 15);
            RoundedTextField passwordField = new RoundedTextField(20, 15);

            panel.add(usernameField);
            panel.add(emailField);
            panel.add(passwordField);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
