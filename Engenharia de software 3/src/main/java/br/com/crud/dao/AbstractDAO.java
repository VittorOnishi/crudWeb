package br.com.crud.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.crud.controller.Conexao;

public class AbstractDAO {
	
	protected Connection con;
	
	public AbstractDAO(Connection con){
		 this.con = con;
	}
	
	protected void openConnection(){
		try {
			
			if(con == null || con.isClosed())
				con = Conexao.getConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

