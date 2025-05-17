package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.TiposCargo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewCadastroFuncPageAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=CadastroFuncionario");

        req.setAttribute("cargos", TiposCargo.values());

        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
