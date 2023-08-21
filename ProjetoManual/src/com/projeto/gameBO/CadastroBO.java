package com.projeto.gameBO;

import com.projeto.gameDAO.CadastroDAO;
import com.projeto.gameVO.cadastroVO;

public class CadastroBO {
    private CadastroDAO cadastroDAO;

    public CadastroBO() {
        cadastroDAO = new CadastroDAO();
    }

    public boolean cadastrarUsuario(String nome, String senha, String email) {
        cadastroVO usuario = new cadastroVO(nome, senha, email);
        cadastroDAO.cadastrarUsuario(usuario);
        return true; 
    }
}

