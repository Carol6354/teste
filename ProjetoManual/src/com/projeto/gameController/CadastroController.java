package com.projeto.gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projeto.gameBO.CadastroBO;
import com.projeto.gameView.CadastroView;

public class CadastroController {

    private CadastroBO cadastroBO;
    private CadastroView cadastroView;

    public CadastroController() {
        cadastroBO = new CadastroBO();
        cadastroView = new CadastroView();

        cadastroView.addCadastroListener(new CadastroListener());
    }

    private class CadastroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = cadastroView.getNome();
            String email = cadastroView.getEmail();
            String senha = cadastroView.getSenha();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                
                cadastroView.exibirMensagemErro("Preencha todos os campos.");
                return;
            }

            boolean sucesso = cadastroBO.cadastrarUsuario(nome, senha, email);

            if (sucesso) {
                
                cadastroView.exibirMensagemSucesso("Cadastro Concluído!!");
            } else {
                
                cadastroView.exibirMensagemErro("Erro ao cadastrar usuário.");
            }
        }
    }

    public static void main(String[] args) {
        new CadastroController();
    }
}
