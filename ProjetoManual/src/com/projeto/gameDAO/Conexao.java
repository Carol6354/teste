package com.projeto.gameDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static void main(String[]args) {
		@SuppressWarnings("unused")
		Connection conx = null;
		String url = "jdbc:mysql://localhost:3306/Projetogame";
		String user = "root";
		String password = "ANA122520";
		try {
				conx = DriverManager.getConnection (url,user,password);
				System.out.println ("PARABENS CAROLINA");
		}catch (Exception erro) {
			System.out.println ("ARRUMA PORRA");
		}
	}
	
}
   