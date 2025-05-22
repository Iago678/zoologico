package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Animal;
import br.zoo.model.ETipoUsuario;
import br.zoo.model.Usuario;
import br.zoo.model.Visitante;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.VisitanteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;



public class CallDeleteAnimalAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("cpId"));

        try {
            new AnimalDAO().apagarByKey(id);
            req.setAttribute("msg",  "Animal apagado com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao apagar "+e.getMessage());
        }

        new CallViewAdminAnimaisPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() != ETipoUsuario.VISITANTE;
    }
}
