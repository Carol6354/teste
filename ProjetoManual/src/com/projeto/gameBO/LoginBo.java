package com.projeto.gameBO;

import com.projeto.gameDAO.LoginDao;
import com.projeto.gameVO.LoginVo;

public class LoginBo {
    private LoginDao loginDao;

    public LoginBo() {
        loginDao = new LoginDao();
    }

    public boolean autenticarUsuario(String nome, String senha) {
        LoginVo usuarioEncontrado = loginDao.realizarLogin(nome, senha);
        return usuarioEncontrado != null;
    }
}
