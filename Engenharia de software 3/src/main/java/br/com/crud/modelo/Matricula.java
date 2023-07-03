package br.com.crud.modelo;

import java.util.ArrayList;

public class Matricula extends EntidadeDominio{
	
	Curso crs;
	
	public Matricula(Curso crs){
		setCurso(crs);
	}
	
	public Curso getCurso(){
		return crs;
	}

	public void setCurso(Curso crs) {
		this.crs = crs;
	}
	
	
	
	
	}
	
	

