package br.zoo.commander;

import br.zoo.model.Cliente;
import br.zoo.model.ETipoUsuario;
import br.zoo.model.Usuario;
import br.zoo.util.CriptoUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(value = "teste")
public class TestaBanco extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EST_PU");
        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario(0, "Iago da Silva", "iago",
                CriptoUtil.getHash("123"), new Date(), ETipoUsuario.ADMIN);

        Cliente cli = new Cliente(0, "Pedrin Rocha", "ped",
                CriptoUtil.getHash("123"), new Date(), ETipoUsuario.CLIENTE, "pedrin@exemplo.com");

        em.getTransaction().begin();
        em.persist(u);
        em.persist(cli);


        em.getTransaction().commit();

        resp.getWriter().write("Dados inseridos com sucesso!");
    }
}
