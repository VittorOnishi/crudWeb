package br.com.crud.modelo;

import java.util.Objects;

public class Endereco extends EntidadeDominio{
	
	 private String logradouro;
	    private String numero;
	    private String complemento;
	    private String cep;
	    private Cidade cidade;
	   


		public Endereco(String logradouro, String numero, String complemento, String cep, Cidade cidade) {
			setLogradouro(logradouro);
			setNumero(numero);
			setComplemento(complemento);
	        setCep(cep);
	        setCidade(cidade);
	    }

		public boolean validarEndereco() {
	        return !(logradouro.isEmpty() || numero.isEmpty() || cep.isEmpty() || cidade == null);
	    }

	    public String getLogradouro() {
	        return logradouro;
	    }

	    public void setLogradouro(String logradouro) {
	    	Objects.requireNonNull(logradouro);
	    	logradouro = logradouro.trim().toUpperCase();

			this.logradouro = logradouro;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
			this.numero = numero;
	    }

	    public String getComplemento() {
	        return complemento;
	    }

	    public void setComplemento(String complemento) {
	        this.complemento = complemento;
	    }
	    
	    public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public Cidade getCidade() {
	        return cidade;
	    }

	    public void setCidade(Cidade cidade) {
	        this.cidade = cidade;
	    }


	

}
