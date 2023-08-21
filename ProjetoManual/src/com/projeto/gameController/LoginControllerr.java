package com.projeto.gameController;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projeto.gameBO.LoginBo;
import com.projeto.gameView.Loginview;

public class LoginControllerr {

    private LoginBo loginBo;
    private Loginview loginview;

    public LoginControllerr() {
        loginBo = new LoginBo();
        loginview = new Loginview();

        //loginview.addLoginListener(new LoginListener());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginControllerr();
            }
        });
    }

   // private class LoginListener implements ActionListener {
       // public void actionPerformed(ActionEvent e) {
          //  String nome = loginview.getNome();
            //String senha = loginview.getSenha();

            //if (nome.isEmpty() || senha.isEmpty()) {
               // loginview.exibirMensagemErro("Preencha todos os campos.");
               // return;
            //}

           // boolean autenticado = loginBo.autenticarUsuario(nome, senha);

           // if (autenticado) {
               // loginview.exibirMensagemSucesso("Login Concluído!!");
           // } else {
               // loginview.exibirMensagemErro("Erro ao realizar login.");
            //}
       // }
    //}
}
