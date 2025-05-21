package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Animal;
import br.zoo.model.ConsultaVet;
import br.zoo.model.Veterinario;
import br.zoo.model.VisitaVet;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.VeterinarioDAO;
import br.zoo.model.dao.impl.VisitaVetDAO;
import br.zoo.model.dao.impl.VisitanteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

public class CallSaveVisitaVetAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VisitaVet visita = new VisitaVet();
        Animal animal = new AnimalDAO().buscar(Integer.valueOf(req.getParameter("cpAnimal")));
        Veterinario vet = new VeterinarioDAO().buscar(Integer.valueOf(req.getParameter("cpVet")));
        visita.setAnimal(animal);
        visita.setVet(vet);
        visita.setData(LocalDate.parse(req.getParameter("cpData")));
        visita.setServico(ConsultaVet.valueOf(req.getParameter("cpServ")));

        try {
            new VisitaVetDAO().inserir(visita);
            req.setAttribute("msg", " Visita cadastrada com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewVisitaVetPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        return true;
    }
}
