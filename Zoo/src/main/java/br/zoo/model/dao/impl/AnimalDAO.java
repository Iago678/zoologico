package br.zoo.model.dao.impl;

import br.zoo.model.Animal;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.util.CriptoUtil;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;


public class AnimalDAO extends GenericsDAO<Animal, Integer> {

    @Override
    public Animal inserir(Animal obj) throws Exception {
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
    public Animal alterar(Animal obj) throws Exception {
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
    public Animal apagar(Animal obj) throws Exception {
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
    public Animal apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            Animal a = buscar(key);
            connection.remove(a);
            connection.getTransaction().commit();
            return a;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public Animal buscar(Integer key) {
        Animal a = connection.find(Animal.class, key);
        return a;
    }

    @Override
    public List<Animal> buscarTodos() {
        List<Animal> listaAni = connection.createQuery("select a from Animal a ").getResultList();
        return listaAni;
    }

    public List<Animal> buscarByName(String nome){
        String jpql = "select a from Animal a where a.nome like :nm ";
        Query q = connection.createQuery(jpql);
        q.setParameter("nm", "%"+nome+"%");
        return q.getResultList();
    }

}
