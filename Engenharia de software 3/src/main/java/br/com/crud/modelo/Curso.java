package br.com.crud.modelo;

public class Curso extends EntidadeDominio{
	
	private String nome;
	
	
	public Curso(int id) {
		setId(id);	
	}
	
	public Curso(String nome) {
		setNome(nome);

	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	

}
