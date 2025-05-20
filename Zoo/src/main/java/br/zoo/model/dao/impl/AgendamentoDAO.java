package br.zoo.model.dao.impl;

import br.zoo.model.Agendamento;
import br.zoo.model.Usuario;
import br.zoo.model.dao.GenericsDAO;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;


public class AgendamentoDAO extends GenericsDAO<Agendamento, Integer> {

    @Override
    public Agendamento inserir(Agendamento obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.persist(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
        finally {
            close();
        }
    }

    @Override
    public Agendamento alterar(Agendamento obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.persist(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Agendamento apagar(Agendamento obj) throws Exception {
        try {
            connection.getTransaction().begin();
            connection.remove(obj);
            connection.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Agendamento apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Agendamento a = buscar(key);
            connection.remove(a);
            connection.getTransaction().commit();
            return a;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Agendamento buscar(Integer key) {
        Agendamento a = connection.find(Agendamento.class, key);
        return a;
    }

    @Override
    public List<Agendamento> buscarTodos() {
        List<Agendamento> listaAge = connection.createQuery("select a from Agendamento a ").getResultList();
        return listaAge;
    }

    public List<Agendamento> buscarByDate(LocalDate data){
        String jpql = "select a from Agendamento a where a.dia = :data";
        Query q = connection.createQuery(jpql);
        q.setParameter("data", data);
        return q.getResultList();
    }

    public Agendamento buscarByUser(Usuario user){
        String jpql = "select a from Agendamento a where a.user = :usuario";
        Query q = connection.createQuery(jpql);
        q.setParameter("usuario", user);
        return (Agendamento) q.getResultList();
    }

}
