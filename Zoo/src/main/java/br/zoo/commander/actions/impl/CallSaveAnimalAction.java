package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.*;
import br.zoo.model.dao.impl.AnimalDAO;
import br.zoo.model.dao.impl.VisitanteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class CallSaveAnimalAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Animal a = new Animal();
        a.setEspecie(req.getParameter("cpEspecie"));
        a.setDataChegada(new Date());
        a.setEstadoSaude(SaudeAnimal.valueOf(req.getParameter("cpSaude")));
        a.setNome((req.getParameter("cpNomeAnm")));
        a.setNomeCientifico(req.getParameter("cpNomeCient"));
        a.setEmExpo(Boolean.parseBoolean(req.getParameter("cpExpo")));
        a.setIdade(Integer.parseInt(req.getParameter("cpIdade")));
        a.setSexo(SexoAnimal.valueOf(req.getParameter("cpSexo")));
        a.setHabitat(Habitat.valueOf(req.getParameter("cpHabitat")));
        a.setRecinto(Recinto.valueOf(req.getParameter("cpRecinto")));

        try {
            new AnimalDAO().inserir(a);
            req.setAttribute("msg", a.getNome()+" Seu cadastro foi feito com sucesso!!!");
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
