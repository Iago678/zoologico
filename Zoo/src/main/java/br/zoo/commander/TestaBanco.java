package br.zoo.commander;

import br.zoo.model.*;
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
import java.time.LocalDate;
import java.util.Date;

@WebServlet(value = "teste")
public class TestaBanco extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EST_PU");
        EntityManager em = emf.createEntityManager();

        Admin u = new Admin(0, "Zezin da Silva", "ze",
                CriptoUtil.getHash("123"), new Date(), ETipoUsuario.ADMIN);

        Visitante cli = new Visitante(1, "Luiz Rocha", "lulu",
                CriptoUtil.getHash("123"), new Date(), ETipoUsuario.VISITANTE, "l@gmail.com");

        Funcionario func = new Funcionario(2, "Iago Silva", "iago",
                CriptoUtil.getHash("123"), new Date(), ETipoUsuario.FUNCIONARIO, 12, TiposCargo.GUIA);

        Veterinario vet = new Veterinario(null, "SP12345", "329999-9999", "antonio");

        Animal anm = new Animal(4, "tigre", "Tigre Dente de Sabre", "Trigrus", new Date(), SaudeAnimal.SAUDAVEL, SexoAnimal.FEMEA, 12, true);

        em.getTransaction().begin();
        em.persist(u);
        em.persist(cli);
        em.persist(func);
        em.persist(vet);
        em.persist(anm);


        em.getTransaction().commit();

        resp.getWriter().write("Dados inseridos com sucesso!");
    }
}
