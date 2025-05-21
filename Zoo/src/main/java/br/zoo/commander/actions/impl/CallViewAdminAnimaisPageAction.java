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

public class CallViewAdminAnimaisPageAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=AdminAnimais");

        req.setAttribute("saude", SaudeAnimal.values());
        req.setAttribute("sexo", SexoAnimal.values());
        req.setAttribute("animais", new AnimalDAO().buscarTodos());

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
