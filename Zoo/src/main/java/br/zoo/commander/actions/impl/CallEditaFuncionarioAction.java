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

public class CallEditaFuncionarioAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("cpId"));
        Funcionario f = new FuncionarioDAO().buscar(id);
        f.setNome(req.getParameter("cpNome"));
        f.setCargo(TiposCargo.valueOf(req.getParameter("cpCargo")));
        f.setSalario(Double.parseDouble(req.getParameter("cpSalario")));
        f.setLogin(req.getParameter("cpLogin"));

        try {
            new FuncionarioDAO().alterar(f);
            req.setAttribute("msg", "Alteração feita com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewFuncionariosDtoPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
