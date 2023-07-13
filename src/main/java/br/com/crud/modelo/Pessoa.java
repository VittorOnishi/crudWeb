package br.com.crud.modelo;

import java.util.Objects;

public class Pessoa extends EntidadeDominio{
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Objects.requireNonNull(nome);
		nome = nome.trim().toUpperCase();
		this.nome = nome;
	}
	
	

}
