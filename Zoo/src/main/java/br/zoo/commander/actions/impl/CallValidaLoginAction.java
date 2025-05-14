package br.zoo.commander.actions.impl;

import br.zoo.model.Usuario;
import br.zoo.model.dao.impl.ClienteDAO;
import br.zoo.model.dao.impl.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallValidaLoginAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("cpLogin");
        String senha = req.getParameter("cpSenha");

        Usuario usu = new UsuarioDAO().buscarByLoginAndSenha(nome,senha);

        if (usu == null){
            req.setAttribute("err","login ou senha incorreta");
            RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=Login");
            rd.forward(req,resp);
            return;
        }

        req.getSession().setAttribute("user",usu);
        req.getSession().setAttribute("estaLogado","1");
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?page=HomeLogado");
        rd.forward(req,resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
