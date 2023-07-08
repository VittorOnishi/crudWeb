package br.com.crud.modelo;

import java.time.LocalDate;

public class EntidadeDominio implements IEntidade {

	private Integer id;

	private LocalDate dtCadastro;

	public EntidadeDominio() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
}
