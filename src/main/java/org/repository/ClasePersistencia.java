package org.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClasePersistencia {
    private final static String unidadPersistencia="prueba";
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
    public static EntityManager EntityManejador(){

        // Crear el EntityManager
        return emf.createEntityManager();
    }

}
