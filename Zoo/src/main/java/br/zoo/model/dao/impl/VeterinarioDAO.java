package br.zoo.model.dao.impl;

import br.zoo.model.Veterinario;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.Query;
import java.util.List;

public class VeterinarioDAO extends GenericsDAO<Veterinario, Integer> {
    @Override
    public Veterinario inserir(Veterinario obj) throws Exception {
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
    public Veterinario alterar(Veterinario obj) throws Exception {
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
    public Veterinario apagar(Veterinario obj) throws Exception {
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
    public Veterinario apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Veterinario v = buscar(key);
            connection.remove(v);
            connection.getTransaction().commit();
            return v;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Veterinario buscar(Integer key) {
        Veterinario v = connection.find(Veterinario.class, key);
        return v;
    }

    @Override
    public List<Veterinario> buscarTodos() {
        String jpql = "select v from Veterinario v";
        Query q = connection.createQuery(jpql);
        return q.getResultList();
    }

    public List<Veterinario> buscarByName(String nome){
        String jpql = "select v from Veterinario v where v.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }
}
