package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.*;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.FuncionarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewEditaFuncPageAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=EditaFunc");

        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);
        req.setAttribute("funcionario", new FuncionarioDAO().buscar(id));
        req.setAttribute("cargos", TiposCargo.values());

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
