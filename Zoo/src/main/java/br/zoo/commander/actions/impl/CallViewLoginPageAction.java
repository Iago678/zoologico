package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewLoginPageAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=Login");

        rd.forward(req,resp);

    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
