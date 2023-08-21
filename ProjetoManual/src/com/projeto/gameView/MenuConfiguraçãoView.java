package com.projeto.gameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  MenuConfiguraçãoView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Configurações");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);

            JPanel configPanel = new JPanel();
            configPanel.setLayout(new GridLayout(4, 2));

            JLabel volumeLabel = new JLabel("Volume:");
            JSlider volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

            JLabel graphicsLabel = new JLabel("Gráficos:");
            String[] graphicsOptions = {"Baixo", "Médio", "Alto"};
            JComboBox<String> graphicsComboBox = new JComboBox<>(graphicsOptions);

            JButton saveButton = new JButton("Salvar");

            JLabel deleteAccountLabel = new JLabel("Excluir Conta:");
            JButton deleteAccountButton = new JButton("Excluir");

            configPanel.add(volumeLabel);
            configPanel.add(volumeSlider);
            configPanel.add(graphicsLabel);
            configPanel.add(graphicsComboBox);
            configPanel.add(deleteAccountLabel);
            configPanel.add(deleteAccountButton);
            configPanel.add(saveButton);

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int volume = volumeSlider.getValue();
                    String graphicsSetting = (String) graphicsComboBox.getSelectedItem();
                    // Implemente a lógica real para salvar as configurações
                    JOptionPane.showMessageDialog(frame, "Configurações salvas!");
                }
            });

            deleteAccountButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(
                            frame,
                            "Tem certeza que deseja excluir sua conta?\nEssa ação é irreversível!",
                            "Excluir Conta",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Implemente a lógica real para excluir a conta
                        JOptionPane.showMessageDialog(frame, "Conta excluída!");
                    }
                }
            });

            frame.add(configPanel);
            frame.setVisible(true);
        });
    }
}
