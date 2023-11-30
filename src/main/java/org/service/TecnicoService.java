package org.service;

import lombok.NoArgsConstructor;
import org.entity.Tecnico;
import org.repository.ClasePersistencia;
import org.repository.TecnicoRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
@NoArgsConstructor
public class TecnicoService implements TecnicoRepositorie {




    @Override
    public void create(Tecnico tecnico) {
        EntityManager em=ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(tecnico);
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
    public void update(Tecnico tecnico) {
        EntityManager em=ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // actualiza el cliente en la base de datos (esto también creará la tabla si no existe)
            em.merge(tecnico);
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
    public void delate(Tecnico tecnico) {}

    @Override
    public Tecnico retrive(int id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();

        Tecnico tecnicoRecuperado;

        try {
            // Utilizar el método find para buscar y recuperar un técnico por su ID
            tecnicoRecuperado = em.find(Tecnico.class,id);

            // Verificar si el técnico fue encontrado
            if (tecnicoRecuperado != null) {
                System.out.println("Técnico recuperado: " + tecnicoRecuperado);
            } else {
                System.out.println("Técnico no encontrado con el ID: " +id);
            }
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
        return tecnicoRecuperado;


    }

    public Tecnico retriveByDni(int dni){
        return null;
    }

    @Override
    public Tecnico retriveAll() {
        return null;
    }

    @Override
    public Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin) {
        return null;
    }

    @Override
    public Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin) {
        return null;
    }

    @Override
    public Tecnico NumeroDeIncidentes(LocalDate inicio, LocalDate fin) {
        return null;
    }

    @Override
    public Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin) {
        return null;
    }
}
