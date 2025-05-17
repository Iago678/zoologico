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
        comandos.put("logout",new CallLogoutAction());
        comandos.put("cadastro",new CallViewCadastrorPageAction());
        comandos.put("cadastroFunc",new CallViewCadastroFuncPageAction());
        comandos.put("saveCliente", new CallSaveVisitanteAction());
        comandos.put("saveFunc", new CallSaveFuncionarioAction());
        comandos.put("error",new CallViewErrorPageAction());
        comandos.put("valLog",new CallValidaLoginAction());
        comandos.put("HomeLog",new CallViewHomeLogadoPageAction());
        comandos.put("HomeFunc",new CallViewHomeFuncionarioPageAction());
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
