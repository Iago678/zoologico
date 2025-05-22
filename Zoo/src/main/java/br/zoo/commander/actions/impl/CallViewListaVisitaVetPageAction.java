package br.zoo.commander.actions.impl;

import br.zoo.model.ETipoUsuario;
import br.zoo.model.Usuario;
import br.zoo.model.dao.impl.VisitaVetDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewListaVisitaVetPageAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=ListaVisitasVet");

        req.setAttribute("visita", new VisitaVetDAO().buscarTodosView());

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() != ETipoUsuario.VISITANTE;
    }
}
