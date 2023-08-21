package com.projeto.gameDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projeto.gameVO.LoginVo;

public class LoginDao {

    private String url = "jdbc:mysql://localhost:3306/projetogame";
    private String usuarioBD = "root";
    private String senhaBD = "ANA122520";

    public LoginVo realizarLogin(String nome, String senha) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginVo usuarioE = null;

        try {
            conn = DriverManager.getConnection(url, usuarioBD, senhaBD);
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nomeUsuario = rs.getString("nome");
                String senhaUsuario = rs.getString("senha");
                usuarioE = new LoginVo(nomeUsuario, senhaUsuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarioE;
    }
}
