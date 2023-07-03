package br.com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.command.AlterarCommand;
import br.com.crud.command.CandidatoList;
import br.com.crud.command.ConsultarCommand;
import br.com.crud.command.ExcluirCommand;
import br.com.crud.command.ExibirCommand;
import br.com.crud.command.FormCadastro;
import br.com.crud.command.ICommand;
import br.com.crud.command.SalvarCommand;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.viewhelper.IViewHelper;
import br.com.crud.viewhelper.VHCandidato;
import br.com.crud.viewhelper.VHCurso;

@WebServlet("/ctrl")
public class Controle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> viewHelpers;

    public Controle() {
        super();
        commands = new HashMap<>();
        viewHelpers = new HashMap<>();

        // Mapear os comandos e view helpers correspondentes
        commands.put("CadastrarCandidato", new SalvarCommand());
        commands.put("CadastrarCandidatoForm", new FormCadastro());
        commands.put("RemoveCandidato", new ExcluirCommand());
        commands.put("CandidatoList", new CandidatoList());
        commands.put("ExibeCandidato", new ExibirCommand());
        commands.put("AlterarCandidato", new AlterarCommand());
        commands.put("ListarCandidato", new ConsultarCommand());
        

        viewHelpers.put("CadastrarCandidatoForm", new VHCurso());
        viewHelpers.put("CadastrarCandidato", new VHCandidato());
        viewHelpers.put("RemoveCandidato", new VHCandidato());
        viewHelpers.put("CandidatoList", new VHCandidato());
        viewHelpers.put("ListarCandidato", new VHCandidato());
        viewHelpers.put("ExibeCandidato", new VHCandidato());
        viewHelpers.put("AlterarCandidato", new VHCandidato());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paramAcao = request.getParameter("acao");
        
        System.out.println(paramAcao);

        ICommand command = commands.get(paramAcao);
        IViewHelper viewHelper = viewHelpers.get(paramAcao);

        if (command != null && viewHelper != null) {
            EntidadeDominio entidade = viewHelper.getEntidade(request, response);
            
            
            Resultado rstd = new Resultado();
            rstd = command.execute(entidade);
                       
            viewHelper.setView(rstd.getEntidades(), request, response);
            
            if(rstd.getMsg() != null) {
            	
            	PrintWriter out = response.getWriter();
        		out.print(rstd.getMsg());
            	
            }
            
            String nextPage = rstd.getNextPage();
            

            if (nextPage.startsWith("forward:") && rstd.getMsg() == null) {
                String forwardPage = nextPage.substring("forward:".length());
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/" + forwardPage);
                dispatcher.forward(request, response);
                
            } else if (nextPage.startsWith("redirect:")) {
                String redirectPage = nextPage.substring("redirect:".length());
                response.sendRedirect(redirectPage);
            } 
    }
}
}
