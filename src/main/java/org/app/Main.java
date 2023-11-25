package org.app;

import org.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Crear el EntityManagerFactory usando la unidad de persistencia definida en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");

        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();

        // Iniciar la transacción
        em.getTransaction().begin();

        // Crear un nuevo cliente
        Cliente cliente = new Cliente();
        cliente.setRazonSocial("John");
        cliente.setCuit("2020");

        // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
        em.persist(cliente);

        // Commit de la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}


//    public static void insert(Cliente cliente){
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit-prueba");
//        EntityManager em=emf.createEntityManager();
//
//        try{
//            em.getTransaction().begin();
//            em.persist(cliente);
//            em.getTransaction().commit();
//        }catch (Exception e){
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//        }
//        em.close();
//        emf.close();
//
//    }