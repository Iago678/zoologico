package br.zoo.commander;

import br.zoo.commander.actions.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import br.zoo.commander.actions.ICommanderAction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/")
public class CommanderController extends HttpServlet {

    private static Map<String, ICommanderAction> comandos = new HashMap<>();

    static{
        comandos.put(null, new CallViewHomePageAction());
        comandos.put("login",new CallViewLoginPageAction());
        comandos.put("logout",new CallLogoutAction());//
        comandos.put("cadastro",new CallViewCadastrorPageAction());//
        comandos.put("cadastroFunc",new CallViewFuncionarioPageAction());//
        comandos.put("cadastroVet",new CallViewVeterinarioPageAction());//
        comandos.put("visitaVet",new CallViewVisitaVetPageAction());//
        comandos.put("saveCliente", new CallSaveVisitanteAction());//
        comandos.put("saveFunc", new CallSaveFuncionarioAction());//
        comandos.put("saveAnimal", new CallSaveAnimalAction());//
        comandos.put("saveVet", new CallSaveVetAction());//
        comandos.put("saveVisitaVet", new CallSaveVisitaVetAction());//
        comandos.put("error",new CallViewErrorPageAction());//
        comandos.put("valLog",new CallValidaLoginAction());//
        comandos.put("HomeLog",new CallViewHomeLogadoPageAction());//
        comandos.put("AgendaVis",new CallViewAgendaVisitaPageAction());//
        comandos.put("saveVisita",new CallSaveAgendamentoAction());//
        comandos.put("saveAlimentacao",new CallSaveAlimentacaoAction());//
        comandos.put("animais",new CallViewFuncAnimaisPageAction());//
        comandos.put("listaAnimais",new CallViewAnimaisPageAction());
        comandos.put("editarAnimal",new CallViewEditaAnimaisPageAction());
        comandos.put("editarFunc",new CallViewEditaFuncPageAction());
        comandos.put("updateAnimal",new CallEditaAnimalAction());
        comandos.put("updateFunc",new CallEditaFuncionarioAction());
        comandos.put("updateVet",new CallEditaVeterinarioAction());
        comandos.put("delFunc",new CallDeleteFuncionarioAction());//
        comandos.put("delAnimal",new CallDeleteAnimalAction());//
        comandos.put("adminAnimais",new CallViewAdminAnimaisPageAction());//
        comandos.put("adminFunc",new CallViewFuncionariosDtoPageAction());
        comandos.put("adminVets",new CallViewListaVetsPageAction());
        comandos.put("editarVet",new CallViewEditaVetPageAction());
        comandos.put("infoAnimais",new CallViewInfoAnimaisPageAction());
        comandos.put("listaVisitaVet",new CallViewListaVisitaVetPageAction());
    }


    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ac = req.getParameter("ac");
        ICommanderAction action = comandos.get(ac);

        if (action == null){
            req.setAttribute("msg","Comando '"+action+"' não encontrado");
            comandos.get("error").execute(req,resp);
        }

        if (action.isAuthorized(req)){
            action.execute(req, resp);
        }else{
            req.setAttribute("msg","acesso não autorizado");
            comandos.get("error").execute(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }
}
