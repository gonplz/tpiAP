package org.service;

import org.entity.Incidente;
import org.repository.ClasePersistencia;
import org.repository.CrudRepositorie;

import javax.persistence.EntityManager;

public class IncidenteService implements CrudRepositorie<Incidente> {

    @Override
    public void create(Incidente incidente) {
        EntityManager em= ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(incidente);
            // Commit de la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }


    }

    @Override
    public void update(Incidente incidente) {}

    @Override
    public void delate(Incidente incidente) {}

    @Override
    public Incidente retrive(int id) {
        return null;
    }

    @Override
    public Incidente retriveAll() {
        return null;
    }
}
