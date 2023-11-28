package org.service;

import org.entity.Reporte;
import org.repository.CrudRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReporteCrud implements CrudRepositorie<Reporte> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");

    @Override
    public void create(Reporte reporte) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reporte);
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
    public void update(Reporte reporte) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(reporte);
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
    public void delete(Reporte reporte) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            reporte = em.merge(reporte);
            em.remove(reporte);
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
    public Reporte findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Reporte.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Reporte> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Reporte> query = em.createQuery("SELECT r FROM Reporte r", Reporte.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
