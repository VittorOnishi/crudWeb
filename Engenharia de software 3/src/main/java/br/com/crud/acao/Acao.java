package br.com.crud.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
}
		
