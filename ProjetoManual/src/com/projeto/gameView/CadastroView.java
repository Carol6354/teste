package com.projeto.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CadastroView extends JFrame {

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public CadastroView() {
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920, 1080);
        setLocationRelativeTo(null);

        setContentPane(new JLabel(new ImageIcon("C:\\Users\\anamo\\Downloads\\tela de cadastro (2).png")));

        initComponents();
        defineEvents();

        setVisible(true);
    }

    public void initComponents() {
        Container container = getContentPane();
        container.setLayout(null); 

        usernameField = new JTextField(20);
        Font font = new Font("", Font.PLAIN, 22);
        usernameField.setFont(font);
        usernameField.setBounds(622, 300, 400, 40);

        emailField = new JTextField(20);
        emailField.setFont(font);
        emailField.setBounds(618, 408, 400, 40);

        passwordField = new JPasswordField(20);
        passwordField.setFont(font);
        passwordField.setBounds(618, 515, 400, 40);

        JButton LButton = new JButton("CONCLUIR");
        Font buttonFont = new Font("", Font.PLAIN, 20);
        LButton.setFont(buttonFont);
        LButton.setForeground(Color.WHITE);
        LButton.setBounds(612, 618, 310, 30);

        LButton.setContentAreaFilled(false);
        LButton.setBorderPainted(false);
        
        container.add(usernameField);
        container.add(emailField);
        container.add(passwordField);
        container.add(LButton);
    }

    public void defineEvents() {
        JButton LButton = (JButton) getContentPane().getComponent(3);
        LButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }

        });
    }

    public String getNome() {
        return usernameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getSenha() {
        return new String(passwordField.getPassword());
    }

    public void addCadastroListener(ActionListener listener) {
        JButton LButton = (JButton) getContentPane().getComponent(3);
        LButton.addActionListener(listener);
    }

    public void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

   
        
    }

