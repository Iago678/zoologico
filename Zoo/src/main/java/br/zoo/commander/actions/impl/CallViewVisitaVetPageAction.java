package br.zoo.commander.actions.impl;

import br.zoo.model.ConsultaVet;
import br.zoo.model.TiposCargo;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.FuncionarioDAO;
import br.zoo.model.dao.impl.VeterinarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewVisitaVetPageAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=VisitaVet");

        req.setAttribute("vets", new VeterinarioDAO().buscarTodos());
        req.setAttribute("animais", new AnimalDAO().buscarTodos());
        req.setAttribute("serv", ConsultaVet.values());


        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
