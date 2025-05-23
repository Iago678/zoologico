package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.*;
import br.zoo.model.dao.impl.AlimentacaoDAO;
import br.zoo.model.dao.impl.AnimalDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class CallSaveAlimentacaoAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Alimentacao a = new Alimentacao();
        a.setAnimal(new AnimalDAO().buscar(Integer.valueOf(req.getParameter("cpId"))));
        Funcionario f = (Funcionario) req.getSession().getAttribute("user");
        a.setFuncionario(f);
        a.setData(LocalDate.now());

        try {
            new AlimentacaoDAO().inserir(a);
            req.setAttribute("msg", " Alimentação feita com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewFuncAnimaisPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() != ETipoUsuario.VISITANTE;
    }
}
