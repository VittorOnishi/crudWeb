package br.com.crud.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidato extends Pessoa{

	private Endereco endereco;
	private ArrayList<Filiacao> listaFiliacao = new ArrayList<>();
	private ArrayList<Telefone> listadeTelefones = new ArrayList<>();
	private ArrayList<Curso> listadeCursos = new ArrayList<>();
	private ArrayList<Matricula> listadeMatriculas = new ArrayList<>();
	
	
	public Candidato(String nome, Endereco endereco) {
		setNome(nome);
		this.endereco = endereco;

	}


	public Candidato(String nome) {
		// TODO Auto-generated constructor stub
		setNome(nome);
	}


	public Candidato(Integer id) {
		setId(id);
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public ArrayList<Filiacao> getListaFiliacao() {
		return listaFiliacao;
	}


	public void setListaFiliacao(Filiacao filiacao) {
		if (listaFiliacao.size() > 2) {

			return;
		}
		this.listaFiliacao.add(filiacao);
	}


	public ArrayList<Telefone> getListadeTelefones() {
		return listadeTelefones;
	}


	public void setListadeTelefones(Telefone telefone) {
		if (listadeTelefones.size() > 3) {

			return;
		}
		this.listadeTelefones.add(telefone);
	}


	public ArrayList<Curso> getListadeCursos() {
		return listadeCursos;
	}


	public void setListadeCursos(Curso curso) {
		if (listadeCursos.size() > 3) {

			return;
		}
		this.listadeCursos.add(curso);	
	}


	public ArrayList<Matricula> getListadeMatriculas() {
		return listadeMatriculas;
	}


	public void setListadeMatriculas(Matricula matricula) {
		if (listadeMatriculas.size() > 3) {

			return;
		}
		this.listadeMatriculas.add(matricula);
	}
	
	

	
	


}
