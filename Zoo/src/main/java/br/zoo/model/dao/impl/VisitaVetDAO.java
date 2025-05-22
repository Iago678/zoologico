package br.zoo.model.dao.impl;

import br.zoo.model.Animal;
import br.zoo.model.VisitaVet;
import br.zoo.model.Usuario;
import br.zoo.model.dao.GenericsDAO;
import br.zoo.model.dto.AnimaisViewDto;
import br.zoo.model.dto.VeterinarioViewDto;
import br.zoo.model.dto.VisitaVetViewDto;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VisitaVetDAO extends GenericsDAO<VisitaVet, Integer> {

    @Override
    public VisitaVet inserir(VisitaVet obj) throws Exception {
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
    public VisitaVet alterar(VisitaVet obj) throws Exception {
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
    public VisitaVet apagar(VisitaVet obj) throws Exception {
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
    public VisitaVet apagarByKey(Integer key) throws Exception {
        try {
            connection.getTransaction().begin();
            VisitaVet a = buscar(key);
            connection.remove(a);
            connection.getTransaction().commit();
            return a;
        } catch (Exception e) {
            connection.getTransaction().rollback();
            throw new Exception(e);
        }
    }

    @Override
    public VisitaVet buscar(Integer key) {
        VisitaVet a = connection.find(VisitaVet.class, key);
        return a;
    }

    @Override
    public List<VisitaVet> buscarTodos() {
        List<VisitaVet> listaAge = connection.createQuery("select a from VisitaVet a ").getResultList();
        return listaAge;
    }

    public List<VisitaVet> buscarByDate(LocalDate data){
        String jpql = "select a from VisitaVet a where a.dia = :data";
        Query q = connection.createQuery(jpql);
        q.setParameter("data", data);
        return q.getResultList();
    }

    public List<VisitaVetViewDto> buscarTodosView() {
        String jpql = "SELECT new br.zoo.model.dto.VisitaVetViewDto(" +
                "v.id, v.animal.nome, v.vet.nome, v.data, v.servico, v.valor) " +
                "FROM VisitaVet v " +
                "ORDER BY v.data DESC";
        Query q = connection.createQuery(jpql, VisitaVetViewDto.class);
        return q.getResultList();
    }

}
