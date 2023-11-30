package org.service;

import org.entity.Cliente;
import org.entity.Tecnico;
import org.repository.ClasePersistencia;
import org.repository.CrudRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteService implements CrudRepositorie<Cliente> {


    @Override
    public void create(Cliente cliente) {
        EntityManager em= ClasePersistencia.EntityManejador();
        try{
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(cliente);
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
    public void update(Cliente cliente) {}

    @Override
    public void delate(Cliente cliente) {}

    @Override
    public Cliente retrive(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();

       Cliente  clienteRecuperdado;

        try {
            // Utilizar el método find para buscar y recuperar un técnico por su ID
            clienteRecuperdado = em.find(Cliente.class,id);

            // Verificar si el técnico fue encontrado
            if ( clienteRecuperdado != null) {
                System.out.println("Técnico recuperado: " +  clienteRecuperdado);
            } else {
                System.out.println("Técnico no encontrado con el ID: " +id);
            }
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
        return clienteRecuperdado;



    }

    @Override
    public Cliente retriveAll() {
        return null;
    }
}
