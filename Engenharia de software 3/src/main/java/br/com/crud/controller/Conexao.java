package br.com.crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Conexao {

	private static DataSource dataSource;
	
	public static Connection getConnection() throws SQLException{
   
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		 comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/Es3");
		 comboPooledDataSource.setUser("postgres");
		 comboPooledDataSource.setPassword("1234");

		 comboPooledDataSource.setMaxPoolSize(50);
		 
		 dataSource = comboPooledDataSource;
		
		 return dataSource.getConnection();
    }
	
	

}
