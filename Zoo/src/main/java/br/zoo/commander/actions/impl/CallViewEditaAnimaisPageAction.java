package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.ETipoUsuario;
import br.zoo.model.SaudeAnimal;
import br.zoo.model.SexoAnimal;
import br.zoo.model.Usuario;
import br.zoo.model.dao.impl.AnimalDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewEditaAnimaisPageAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=EditaAnimal");

        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);
        req.setAttribute("animal", new AnimalDAO().buscar(id));
        req.setAttribute("saude", SaudeAnimal.values());
        req.setAttribute("sexo", SexoAnimal.values());

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
