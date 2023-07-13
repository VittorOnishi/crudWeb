package br.com.crud.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filiacao extends Pessoa{
	
	
	private String descricao;
	 
    public Filiacao(String nome, String descricao) {
    	setNome(nome);
    	setDescricao(descricao);
    	
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
    
    

	}
	
    	




