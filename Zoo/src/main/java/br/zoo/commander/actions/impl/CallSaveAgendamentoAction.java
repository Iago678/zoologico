package br.zoo.commander.actions.impl;

import br.zoo.commander.actions.ICommanderAction;
import br.zoo.model.Agendamento;
import br.zoo.model.ETipoUsuario;
import br.zoo.model.Usuario;
import br.zoo.model.Visitante;
import br.zoo.model.dao.impl.AgendamentoDAO;
import br.zoo.model.dao.impl.VisitanteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class CallSaveAgendamentoAction implements ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agendamento a = new Agendamento();
        a.setDia(LocalDate.parse(req.getParameter("cpData")));
        a.setHorario(LocalTime.parse(req.getParameter("cpHorario")));
        a.setQtdPessoas(Integer.parseInt(req.getParameter("cpQtd")));
        Usuario user = (Usuario) req.getSession().getAttribute("user");
        a.setUser(user);

        try {
            new AgendamentoDAO().inserir(a);
            req.setAttribute("msg", user.getNome()+" Sua visita foi agendada com sucesso!!!");
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao agendar "+e.getMessage());
        }

        new CallViewHomeLogadoPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u != null;
    }
}
