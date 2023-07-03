package br.com.crud.viewhelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Curso;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Filiacao;
import br.com.crud.modelo.Matricula;
import br.com.crud.modelo.Telefone;

public class VHCandidato implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		String acao = request.getParameter("acao");
		Candidato cnd = null; 
		
		if(acao.equals("CadastrarCandidato")){
			
			Estado estado = new Estado(request.getParameter("estado"));
			Cidade cidade = new Cidade(estado, request.getParameter("cidade"));
			Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("numero"),
					request.getParameter("complemento"), request.getParameter("cep"), cidade);

			cnd = new Candidato(request.getParameter("nome"), endereco);

			Filiacao paterna = new Filiacao(request.getParameter("nomeDoPai"), "Pai");
			cnd.setListaFiliacao(paterna);
			
			Filiacao materna = new Filiacao(request.getParameter("nomeDaMae"), "Mae");
			cnd.setListaFiliacao(materna);
			
			
			if(request.getParameter("id_curso1") != null 
					&& !request.getParameter("id_curso1").equals("")
					&& !request.getParameter("id_curso1").equals(request.getParameter("id_curso2"))
					&& !request.getParameter("id_curso1").equals(request.getParameter("id_curso3"))){
				
				Curso curso1 = new Curso(Integer.valueOf(request.getParameter("id_curso1")));
	
				Matricula mat1 = new Matricula(curso1);
				cnd.setListadeMatriculas(mat1);
				
			}
			
			if(request.getParameter("id_curso2") != null 
					&& !request.getParameter("id_curso2").equals("")
					&& !request.getParameter("id_curso2").equals(request.getParameter("id_curso3")) 
					&& !request.getParameter("id_curso2").equals(request.getParameter("id_curso1"))){
				
				Curso curso2 = new Curso(Integer.valueOf(request.getParameter("id_curso2")));
				Matricula mat2 = new Matricula(curso2);
				cnd.setListadeMatriculas(mat2);
				
		}
		
			if(request.getParameter("id_curso3") != null 
					&& !request.getParameter("id_curso3").equals("")
					&& !request.getParameter("id_curso3").equals(request.getParameter("id_curso1")) 
					&& !request.getParameter("id_curso3").equals(request.getParameter("id_curso2"))){
				
				Curso curso3 = new Curso(Integer.valueOf(request.getParameter("id_curso3")));
				Matricula mat3 = new Matricula(curso3);
				cnd.setListadeMatriculas(mat3);
				
		}
			
			if(request.getParameter("telefone1") != null && !request.getParameter("telefone1").equals("")
					&& !request.getParameter("telefone1").equals(request.getParameter("telefone2"))
					&& !request.getParameter("telefone1").equals(request.getParameter("telefone3"))
					&& request.getParameter("tipo1") != null && !request.getParameter("tipo1").equals("")){
				
				Telefone tel1 = new Telefone(request.getParameter("telefone1"), request.getParameter("tipo1"));
				cnd.setListadeTelefones(tel1);
			}
			
			if(request.getParameter("telefone2") != null && !request.getParameter("telefone2").trim().equals("") 
					&& request.getParameter("tipo2") != null && !request.getParameter("tipo2").trim().equals("")
					&& !request.getParameter("telefone2").equals(request.getParameter("telefone1"))
					&& !request.getParameter("telefone2").equals(request.getParameter("telefone3"))){
				
				Telefone tel2 = new Telefone(request.getParameter("telefone2"), request.getParameter("tipo2"));
				cnd.setListadeTelefones(tel2);
				
			}
			
			if(request.getParameter("telefone3") != null && !request.getParameter("telefone3").trim().equals("") 
					&& request.getParameter("tipo3") != null && !request.getParameter("tipo3").trim().equals("")
					&& !request.getParameter("telefone3").equals(request.getParameter("telefone2"))
					&& !request.getParameter("telefone3").equals(request.getParameter("telefone1"))){
				
				Telefone tel3 = new Telefone(request.getParameter("telefone3"), request.getParameter("tipo3"));
				cnd.setListadeTelefones(tel3);
				
			}
			
			return cnd;

		}
		
		if(acao.equals("AlterarCandidato")){
			
			String paramId1 = request.getParameter("id");
			Integer cnd_id = Integer.valueOf(paramId1);

			System.out.println("Alterando dados do candidato " + cnd_id);


			Estado estado = new Estado(request.getParameter("estado"));
			Cidade cidade = new Cidade(estado, request.getParameter("cidade"));
			Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("numero"),
					request.getParameter("complemento"), request.getParameter("cep"), cidade);
			
			Filiacao paterna = new Filiacao(request.getParameter("Filiacao paterna"), "Pai");
			cnd.setListaFiliacao(paterna);
			
			Filiacao materna = new Filiacao(request.getParameter("Filiacao materna"), "Mae");
			cnd.setListaFiliacao(materna);
			
			cnd = new Candidato(request.getParameter("nome"), endereco);
			cnd.setDtCadastro(LocalDate.parse(request.getParameter("dtCad")));
			cnd.setId(cnd_id);
			
			if(request.getParameter("id_curso1") != null 
					&& !request.getParameter("id_curso1").equals("")
					&& !request.getParameter("id_curso1").equals(request.getParameter("id_curso2"))
					&& !request.getParameter("id_curso1").equals(request.getParameter("id_curso2"))){
				
				Curso curso1 = new Curso(Integer.valueOf(request.getParameter("id_curso1")));
				Matricula mat1 = new Matricula(curso1);
				mat1.setId(Integer.valueOf(request.getParameter("id_matricula1")));
				cnd.setListadeMatriculas(mat1);
				
			}
			
			if(request.getParameter("id_curso2") != null 
					&& !request.getParameter("id_curso2").equals("")
					&& !request.getParameter("id_curso2").equals(request.getParameter("id_curso1"))
					&& !request.getParameter("id_curso2").equals(request.getParameter("id_curso3"))){
				
				Curso curso2 = new Curso(Integer.valueOf(request.getParameter("id_curso2")));
				Matricula mat2 = new Matricula(curso2);
				mat2.setId(Integer.valueOf(request.getParameter("id_matricula2")));
				cnd.setListadeMatriculas(mat2);
				
		}
			
		
			if(request.getParameter("id_curso3") != null 
					&& !request.getParameter("id_curso3").equals("")
					&& !request.getParameter("id_curso3").equals(request.getParameter("id_curso2"))
					&& !request.getParameter("id_curso3").equals(request.getParameter("id_curso1"))){
				
				Curso curso3 = new Curso(Integer.valueOf(request.getParameter("id_curso3")));
				Matricula mat3 = new Matricula(curso3);
				mat3.setId(Integer.valueOf(request.getParameter("id_matricula3")));
				cnd.setListadeMatriculas(mat3);
				
		}
			
			if(request.getParameter("telefone1") != null && !request.getParameter("telefone1").equals("") 
					&& request.getParameter("tipo1") != null && !request.getParameter("tipo1").equals("") 
					&& !request.getParameter("tel_id1").equals("")
					&& request.getParameter("tel_id1") != null
					&& !request.getParameter("telefone1").equals(request.getParameter("telefone2"))
					&& !request.getParameter("telefone1").equals(request.getParameter("telefone3"))){
				
				Telefone tel1 = new Telefone(request.getParameter("telefone1"), request.getParameter("tipo1"));
				tel1.setId(Integer.valueOf(request.getParameter("tel_id1")));
				cnd.setListadeTelefones(tel1);
				
			}
			
			if(request.getParameter("telefone2") != null && !request.getParameter("telefone2").equals("") 
					&& request.getParameter("tipo2") != null && !request.getParameter("tipo2").equals("") 
					&& !request.getParameter("tel_id2").equals("")
					&& request.getParameter("tel_id2") != null
					&& !request.getParameter("telefone2").equals(request.getParameter("telefone3"))
					&& !request.getParameter("telefone2").equals(request.getParameter("telefone1"))){
				
				Telefone tel2 = new Telefone(request.getParameter("telefone2"), request.getParameter("tipo2"));
				tel2.setId(Integer.valueOf(request.getParameter("tel_id2")));
				cnd.setListadeTelefones(tel2);
			}
			
			if(request.getParameter("telefone3") != null && !request.getParameter("telefone3").equals("") 
					&& request.getParameter("tipo3") != null && !request.getParameter("tipo3").equals("") 
					&& !request.getParameter("tel_id3").equals("")
					&& request.getParameter("tel_id3") != null
					&& !request.getParameter("telefone3").equals(request.getParameter("telefone2"))
					&& !request.getParameter("telefone3").equals(request.getParameter("telefone1"))){
				
				Telefone tel3 = new Telefone(request.getParameter("telefone3"), request.getParameter("tipo3"));
				tel3.setId(Integer.valueOf(request.getParameter("tel_id3")));
				cnd.setListadeTelefones(tel3);
				
			}

		
		return cnd;
		
	}

		if(acao.equals("ListarCandidato")){
			System.out.println("Listando candidatos");
			
			String nome = request.getParameter("pesquisaNome");
				
				cnd = new Candidato(nome);
		
		return cnd;
		
	}
		
		if(acao.equals("ExibeCandidato")){
			
			System.out.println("Mostrando dados do candidato " + request.getParameter("id"));

			String paramId = request.getParameter("id");
			int id = Integer.valueOf(paramId);

			cnd = new Candidato(id);
			
			return cnd;
		}
		
		
		if(acao.equals("RemoveCandidato")){
			
			System.out.println("Removendo candidato");

			String paramId = request.getParameter("id");
			Integer id = Integer.valueOf(paramId);
			
			cnd = new Candidato(id);
			
			return cnd;
		}
		
		if(acao.equals("CandidatoList")){
			
			
			return null;
		}
				
		return null;
}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		request.setAttribute("EntidadeDominio", entDom);	
		
	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		request.setAttribute("EntidadeDominio", entDom);
	}

}
