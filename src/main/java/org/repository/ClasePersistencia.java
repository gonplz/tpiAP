package org.repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClasePersistencia {
    private final static String unidadPersistencia="prueba";

    public static EntityManager EntityManejador(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
        // Crear el EntityManager
        return emf.createEntityManager();
    }

}
