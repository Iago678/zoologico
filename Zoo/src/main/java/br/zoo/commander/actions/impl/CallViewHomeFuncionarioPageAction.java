package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Usuario;
import br.zoo.model.Visitante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewHomeFuncionarioPageAction implements ICommanderAction {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=HomeFuncionario");

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u != null && !(u instanceof Visitante);
    }

}
