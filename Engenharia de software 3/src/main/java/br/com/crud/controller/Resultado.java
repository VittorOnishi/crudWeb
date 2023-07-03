package br.com.crud.controller;

import java.util.List;

import br.com.crud.modelo.EntidadeDominio;

public class Resultado{
	
	private String msg;
	private String nextPage;
	private List<EntidadeDominio> entidades;
	private EntidadeDominio entidade;

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
	public EntidadeDominio getEntidade() {
		return entidade;
	}

	public void setEntidade(EntidadeDominio entidade) {
		this.entidade = entidade;
	}
	

}
