//	package br.com.crud.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.crud.acao.Acao;
//import br.com.crud.command.AlterarCommand;
//import br.com.crud.command.ConsultarCommand;
//import br.com.crud.command.ExcluirCommand;
//import br.com.crud.command.ExibirCommand;
//import br.com.crud.command.ICommand;
//import br.com.crud.command.SalvarCommand;
//import br.com.crud.viewhelper.IViewHelper;
//import br.com.crud.viewhelper.VHCandidato;
//
///**
// * Servlet implementation class Controller
// */
//
//@WebServlet("/controller")
//public class Controller extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	String paramAcao = request.getParameter("acao");
//	
//	String nomeDaClasse = "br.com.crud.acao." + paramAcao;
//	
//	System.out.println(paramAcao);
//	
//	String nome;
//	
//	try {
//		
//		Class classe = Class.forName(nomeDaClasse);
//		Acao acao = (Acao) classe.newInstance();
//		nome = acao.executa(request, response);
//		
//	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
//			| IOException | SQLException e) {
//		throw new ServletException(e);
//	}
//	
//	
//	String[] tipoEEndereco = nome.split(":");
//	if(tipoEEndereco[0].equals("forward")) {
//	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/" + tipoEEndereco[1]);
//	    rd.forward(request, response);
//	}else {
//		response.sendRedirect(tipoEEndereco[1]);
//	}
//
//}
//
//}
