package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Veterinario;
import br.zoo.model.dao.impl.VeterinarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallSaveVetAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Veterinario vet = new Veterinario();
        vet.setCrmv(req.getParameter("cpCrmv"));
        vet.setNome(req.getParameter("cpNomeVet"));
        vet.setTelefone(req.getParameter("cpTel"));


        try {
            new VeterinarioDAO().inserir(vet);
            req.setAttribute("msg", vet.getNome()+" Seu cadastro foi feito com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewVeterinarioPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
