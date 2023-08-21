package com.projeto.gameVO;

public class LoginVo {
    private String nome;
    private String senha;

    public LoginVo(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
