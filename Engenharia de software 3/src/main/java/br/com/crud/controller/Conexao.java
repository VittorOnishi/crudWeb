package br.com.crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
	
	
	public Connection getConnection(){
        Connection conexao = null;
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Es3","postgres","1234");
        } catch (SQLException ex) {
            System.out.println("erro no localhost"+ex);
        }
        
        return conexao;
    }

}
