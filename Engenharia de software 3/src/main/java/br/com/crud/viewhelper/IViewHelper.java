package br.com.crud.viewhelper;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.controller.Resultado;
import br.com.crud.modelo.EntidadeDominio;

public interface IViewHelper {
	
public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response);
	
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)throws ServletException;
	
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)throws ServletException;
	
}
