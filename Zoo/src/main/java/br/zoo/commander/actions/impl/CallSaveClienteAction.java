package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Cliente;
import br.zoo.model.ETipoUsuario;
import br.zoo.model.Usuario;
import br.zoo.model.dao.impl.ClienteDAO;
import br.zoo.model.dao.impl.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class CallSaveClienteAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usu = new Cliente();
        usu.setLogin(req.getParameter("cpLogin"));
        usu.setSenha(req.getParameter("cpSenha"));
        usu.setDataUltimoAcesso(new Date());
        usu.setTipo(ETipoUsuario.CLIENTE);
        usu.setNome(req.getParameter("cpNome"));
        ((Cliente) usu).setEmail(req.getParameter("cpEmail"));

        try {
            new ClienteDAO().inserir((Cliente) usu);
            req.setAttribute("msg", usu.getNome()+" Seu cadastro foi feito com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewLoginPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
