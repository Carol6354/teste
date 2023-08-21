package com.projeto.gameView;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.projeto.gameController.CadastroController;

@SuppressWarnings("serial")
public class Loginview extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    
    
    public Loginview() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\anamo\\Downloads\\tela de login (1).png"))); 

        initComponents();
        defineEvents();

        setVisible(true);
    }

    private void initComponents() {
        Container container = getContentPane();
        container.setLayout(null); 
        
        JLabel nameLabel = new JLabel("Não tem conta?");
        Font CF3= new Font("", Font.PLAIN, 18);
        nameLabel.setFont(CF3);
        nameLabel.setBounds(825, 548, 200, 25);

        JLabel passwordLabel = new JLabel("");
        passwordLabel.setBounds(50, 100, 80, 25);

        usernameField = new JTextField(20);
        Font CF= new Font("Arial", Font.BOLD, 18);
        usernameField.setFont(CF);
        usernameField.setBounds(735, 360, 300, 38);

        passwordField = new JPasswordField(20);
        Font CF1= new Font("", Font.BOLD, 18);
        passwordField.setFont(CF1);
        passwordField.setBounds(735, 497, 300, 38);

        JButton loginButton = new JButton("ENTRAR");
        Font CF2= new Font("ARIAL", Font.PLAIN, 24);
        loginButton.setFont(CF2);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(662, 615, 286, 55);
        
        JButton RedefinirButton = new JButton("Esqueceu a senha?");
        Font CF5 = new Font("ARIAL", Font.PLAIN, 18);
        RedefinirButton.setFont(CF5);
        RedefinirButton.setBounds(520, 550, 200, 25);
        
        JButton registerButton = new JButton("Cadastre-se?");
        Font CF4= new Font("", Font.PLAIN, 18);
        registerButton.setFont(CF4);
        Color purpleColor = new Color(128, 0, 128);
        registerButton.setForeground(purpleColor);
        registerButton.setBounds(916, 548, 200, 25);
        registerButton.setContentAreaFilled(false); 
        registerButton.setBorderPainted(false); 
        loginButton.setContentAreaFilled(false); 
        loginButton.setBorderPainted(false);
        RedefinirButton.setContentAreaFilled(false); 
        RedefinirButton.setBorderPainted(false); 
        
        container.add(nameLabel);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(RedefinirButton);
        container.add(loginButton);
        container.add(registerButton);
    }

    private void defineEvents() {
    	JButton loginButton = (JButton) getContentPane().getComponent(5);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose(); 
                //new menuPrincipal();
            }
        });
            
    }
        public String getNome() {
            return usernameField.getText();
        }

        public String getSenha() {
            return new String(passwordField.getPassword());
        }

        public void realizarLogin(ActionListener listener) {
            JButton registreButton = (JButton) getContentPane().getComponent(5);
            registreButton.addActionListener(listener);
            dispose();
            new CadastroController();
        }

        public void exibirMensagemSucesso(String mensagem) {
            JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        public void exibirMensagemErro(String mensagem) {
            JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Loginview();
            }
        });
    }
}






