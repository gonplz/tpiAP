package org.service;

import org.entity.Incidente;
import org.repository.CrudRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class IncidenteCrud implements CrudRepositorie<Incidente> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");

    @Override
    public void create(Incidente incidente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(incidente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Incidente incidente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(incidente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Incidente incidente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            incidente = em.merge(incidente);
            em.remove(incidente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Incidente findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Incidente.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Incidente> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Incidente> query = em.createQuery("SELECT i FROM Incidente i", Incidente.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
