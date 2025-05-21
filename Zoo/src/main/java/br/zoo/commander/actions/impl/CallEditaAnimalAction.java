package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.*;
import br.zoo.model.dao.impl.AnimalDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class CallEditaAnimalAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Animal a = new AnimalDAO().buscar(id);
        a.setEspecie(req.getParameter("cpEspecie"));
        a.setEstadoSaude(SaudeAnimal.valueOf(req.getParameter("cpSaude")));
        a.setNome((req.getParameter("cpNomeAnm")));
        a.setNomeCientifico(req.getParameter("cpNomeCient"));
        a.setEmExpo(Boolean.parseBoolean(req.getParameter("cpExpo")));
        a.setIdade(Integer.parseInt(req.getParameter("cpIdade")));
        a.setSexo(SexoAnimal.valueOf(req.getParameter("cpSexo")));

        try {
            new AnimalDAO().alterar(a);
            req.setAttribute("msg", " O cadastro foi do"+ a.getNome() +"alterdo com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewAnimaisPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() != ETipoUsuario.VISITANTE;
    }
}
