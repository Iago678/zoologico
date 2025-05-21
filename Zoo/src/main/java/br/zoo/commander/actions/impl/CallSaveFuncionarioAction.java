package br.zoo.commander.actions.impl;

import br.zoo.model.ETipoUsuario;
import br.zoo.model.TiposCargo;
import br.zoo.model.Usuario;
import br.zoo.model.Funcionario;
import br.zoo.model.dao.impl.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class CallSaveFuncionarioAction implements br.zoo.commander.actions.ICommanderAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario admin = (Usuario) req.getSession().getAttribute("user");
        Usuario usu = new Funcionario();
        usu.setLogin(req.getParameter("cpLogin"));
        usu.setSenha(req.getParameter("cpSenha"));
        usu.setDataUltimoAcesso(new Date());
        usu.setTipo(ETipoUsuario.FUNCIONARIO);
        usu.setNome(req.getParameter("cpNome"));
        ((Funcionario) usu).setSalario(Double.parseDouble(req.getParameter("cpSalario")));
        ((Funcionario) usu).setCargo(TiposCargo.valueOf(req.getParameter("cpCargo")));


        try {
            new FuncionarioDAO().inserir((Funcionario) usu);
            req.setAttribute("msg", "Funcionario "+usu.getNome()+"cadastrado com sucesso!!!\n"+admin.getNome());
        } catch (Exception e) {
            req.setAttribute("msg", "Erro ao salvar "+e.getMessage());
        }

        new CallViewFuncionarioPageAction().execute(req, resp);
    }

    @Override
    public boolean isAuthorized(HttpServletRequest req) {
        Usuario u = (Usuario) req.getSession().getAttribute("user");

        return u.getTipo() == ETipoUsuario.ADMIN;
    }
}
