package com.projeto.gameDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.projeto.gameVO.cadastroVO;

public class CadastroDAO {
    private String url = "jdbc:mysql://localhost:3306/projetogame";
    private String usuarioDB = "root"; 
    private String senhaDB = "ANA122520"; 
    
   
    public void cadastrarUsuario(cadastroVO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(url, usuarioDB, senhaDB);
            String sql = "INSERT INTO usuarios (nome, senha, email) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
