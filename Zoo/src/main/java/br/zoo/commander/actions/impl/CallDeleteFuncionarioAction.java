package br.zoo.commander.actions.impl;

import br.zoo.model.ETipoUsuario;
import br.zoo.model.Funcionario;
import br.zoo.model.TiposCargo;
import br.zoo.model.Usuario;
import br.zoo.model.dao.impl.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class CallDeleteFuncionarioAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario admin = (Usuario) req.getSession().getAttribute("user");
        Integer id = Integer.valueOf(req.getParameter("cpId"));
        Funcionario f = new FuncionarioDAO().buscar(id);

        try {
            new FuncionarioDAO().apagarByKey(id);
            req.setAttribute("msg", "Funcionario "+f.getNome()+"apagado com sucesso!!!\n"+admin.getNome());
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao apagar "+e.getMessage());
        }

        new CallViewFuncionarioPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
