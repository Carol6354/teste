package com.projeto.gameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPrincipalView extends JPanel implements ActionListener {

	private JButton[] jbutton;
	private Image background;
	private static int frameW, frameH;
	
	
	public MenuPrincipalView() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frameW = screenSize.width;
		frameH = screenSize.height;
		
		background = new ImageIcon("C:\\Users\\anamo\\Downloads\\tela inicial-jogo (1).png").getImage();
		
		setLayout(new GridBagLayout());
		
		jbutton = new JButton[2];
		
		jbutton[0] = new JButton("CONTINUAR");
		jbutton[0].setPreferredSize(new Dimension(200, 70));
		jbutton[0].setFont(new Font("Arial", Font.PLAIN, 24));
		jbutton[0].setForeground(Color.WHITE);
		jbutton[0].setContentAreaFilled(false);
		jbutton[0].setBorderPainted(false);
		
		jbutton[0].addActionListener(this);
		
		jbutton[1] = new JButton("NOVO JOGO");
		jbutton[1].setPreferredSize(new Dimension(200, 70));
		jbutton[1].setFont(new Font("", Font.PLAIN, 24));
		jbutton[1].setForeground(Color.WHITE);
		jbutton[1].setContentAreaFilled(false);
		jbutton[1].setBorderPainted(false);
		
		jbutton[1].addActionListener(this);
		
		//o 15 move para direita. Quanto maior for mais pra direta vai
		add(jbutton[0], new GridBagConstraints(16, 2, 2, 1, 0, 0,
		        GridBagConstraints.CENTER, GridBagConstraints.NONE,
		        new Insets(560, 10, 0, 10), 0, 0));
				//esse 420 muda a altura, quanto menor for, mais pra cima ele vai
		
		//o 15 move para direita. Quanto maior for mais pra direta vai
		add(jbutton[1], new GridBagConstraints(16, 3, 2, 1, 0, 0,
		        GridBagConstraints.CENTER, GridBagConstraints.NONE,
		        new Insets(40, 10, 0, 10), 0, 0));
				//esse 40 muda a distancia do primeiro botão pro segundo, quanto menor, menos distante
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == jbutton[0]) {
			
			System.out.println("Continuando o jogo");
		}
		
		if(e.getSource() == jbutton[1]) {
			
			System.out.print("Um novo progresso sera criado");
		}
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("NEXUS");
				
		frame.setSize(frameW / 2, frameH / 2);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
		frame.add(new MenuPrincipalView());
		frame.setResizable(false);
		frame.setVisible(true);
	}

}