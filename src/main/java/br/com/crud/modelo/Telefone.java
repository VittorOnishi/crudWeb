package br.com.crud.modelo;

import java.util.Objects;

public class Telefone extends EntidadeDominio{

	private String numero;
	private String tipo;

	public Telefone(String numero, String tipo) {

		setNumero(numero);
		setTipo(tipo);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean validarCadastroTelefone() {
		if(numero.isEmpty() || numero == null || tipo.isEmpty() || tipo == null) {
			return false;
		}
		return true;
	}

}
