package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.*;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.VeterinarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallEditaVeterinarioAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("cpId"));
        Veterinario v = new VeterinarioDAO().buscar(id);
        v.setNome(req.getParameter("cpNomeVet"));
        v.setCrmv(req.getParameter("cpCrmv"));
        v.setTelefone(req.getParameter("cpTel"));


        try {
            new VeterinarioDAO().alterar(v);
            req.setAttribute("msg", " O cadastro foi de"+ v.getNome() +"alterdo com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewListaVetsPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() != ETipoUsuario.VISITANTE;
    }
}
