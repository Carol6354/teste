package com.projeto.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedefinirSenhaview extends JFrame {

    private JTextField emailTextField;
    private JPasswordField newPasswordField;
    private JButton resetButton;

    public RedefinirSenhaview() {
        
        setTitle("Redefinir Senha");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        add(backgroundPanel);

       
        emailTextField = new JTextField(20);
        newPasswordField = new JPasswordField(20);
        resetButton = new JButton("Redefinir Senha");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 3
        		));
        inputPanel.add(new JLabel("E-mail:"));
        inputPanel.add(emailTextField);
        inputPanel.add(new JLabel("Nova Senha:"));
        inputPanel.add(newPasswordField);
        inputPanel.add(resetButton);

        backgroundPanel.add(inputPanel);

        
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        setVisible(true);
    }

    // Classe interna para criar um painel com imagem de fundo
    private class BackgroundPanel extends JPanel {
        private Image backgroundImg;

        public BackgroundPanel() {
            backgroundImg = new ImageIcon("C:\\Users\\anamo\\Downloads\\perfil.png").getImage(); // Substitua pelo caminho correto da imagem
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImg, 1, 2, getWidth(), getHeight(), null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RedefinirSenhaview());
    }
}
