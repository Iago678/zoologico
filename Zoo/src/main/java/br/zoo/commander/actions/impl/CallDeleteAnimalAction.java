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
        String nome = (String) req.getAttribute("cpNome");
        Animal a = (Animal) new AnimalDAO().buscarByName(nome);
        Usuario user = (Usuario) req.getSession().getAttribute("user");


        try {
            new AnimalDAO().apagar(a);
            req.setAttribute("msg", user.getNome()+" Animal apagado com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao apagar "+e.getMessage());
        }

        new CallViewLoginPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
