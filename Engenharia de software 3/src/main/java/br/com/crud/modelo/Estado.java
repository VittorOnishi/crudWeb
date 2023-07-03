package br.com.crud.modelo;

import java.util.Objects;

public class Estado {
	
	private String descricao;

    public Estado(String descricao) {
    	setDescricao(descricao);
    }

	public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

}
