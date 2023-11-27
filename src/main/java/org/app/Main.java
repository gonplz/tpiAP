package org.app;

import org.entity.Cliente;
import org.entity.Estado;
import org.entity.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // Crear el EntityManagerFactory usando la unidad de persistencia definida en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();


        // Crear un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setRazonSocial("Gonza");
        cliente.setCuit("2023");
        cliente.setIncidentes(new HashSet<>());

        Incidente incidente = new Incidente();
        incidente.setCliente(cliente);
        incidente.setDate(LocalDate.now());
        incidente.setDateEstimate(LocalDate.now());
        incidente.setDateResolution(LocalDate.now());
        incidente.setConsideration("XXXXXXX");
        incidente.setTitle("Servicio");
        incidente.setState(Estado.ESTADO_PROCESO);

        try {
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(cliente);
            em.persist(incidente);

            // Commit de la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
    }

}