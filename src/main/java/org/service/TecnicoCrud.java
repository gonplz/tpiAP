package org.service;

import org.entity.Especialidad;
import org.entity.Incidente;
import org.entity.Tecnico;
import org.repository.CrudRepositorie;
import org.repository.TecnicoRepositorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TecnicoCrud implements TecnicoRepositorie {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");

    @Override
    public void create(Tecnico tecnico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tecnico);
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
    public void update(Tecnico tecnico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tecnico);
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
    public void delete(Tecnico tecnico) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            tecnico = em.merge(tecnico);
            em.remove(tecnico);
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
    public Tecnico findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Tecnico.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tecnico> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Tecnico> query = em.createQuery("SELECT t FROM Tecnico t", Tecnico.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin, Tecnico tecnico) {
        // Obtener la lista de incidentes resueltos por el técnico en el rango de fechas
        List<Incidente> incidentesResueltos = tecnico.getProblema().stream()
                .filter(incidente -> incidente.getDateEnd() != null &&
                        incidente.getDateEnd().isAfter(inicio) &&
                        incidente.getDateEnd().isBefore(fin))
                .collect(Collectors.toList());

        // Contar la cantidad de incidentes resueltos por cada técnico
        Map<Tecnico, Long> incidentesPorTecnico = incidentesResueltos.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

        // Encontrar al técnico con más incidentes resueltos
        Tecnico tecnicoConMasIncidentes = incidentesPorTecnico.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        return tecnicoConMasIncidentes;
    }

    public Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin, Especialidad especialidad, Tecnico tecnico) {
        // Obtener la lista de incidentes resueltos por el técnico en el rango de fechas y especialidad
        List<Incidente> incidentesResueltos = tecnico.getProblema().stream()
                .filter(incidente -> incidente.getDateEnd() != null &&
                        incidente.getDateEnd().isAfter(incidente.getDateStart()) &&
                        incidente.getDateEnd().isBefore(incidente.getDateEnd()) &&
                        incidente.getTecnico().getEspecialidad() == especialidad).peek(System.out::println)
                .collect(Collectors.toList());

        // Contar la cantidad de incidentes resueltos por cada técnico y agrupados por especialidad
        Map<Tecnico, Long> incidentesPorTecnico = incidentesResueltos.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

        // Encontrar al técnico con más incidentes resueltos para la especialidad dada
        Tecnico tecnicoConMasIncidentes = incidentesPorTecnico.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        return tecnicoConMasIncidentes;
    }

    public Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin,Tecnico tecnico) {
        // Obtener la lista de incidentes resueltos por el técnico en el rango de fechas
        List<Incidente> incidentesResueltos = tecnico.getProblema().stream()
                .filter(incidente -> incidente.getDateEnd() != null &&
                        incidente.getDateEnd().isAfter(inicio) &&
                        incidente.getDateEnd().isBefore(fin))
                .collect(Collectors.toList());

        // Encontrar al técnico más rápido (menor tiempo de resolución)
        Tecnico tecnicoMasRapido = incidentesResueltos.stream()
                .min(Comparator.comparing(Incidente::getDateEstimate))
                .map(Incidente::getTecnico)
                .orElse(null);

        return tecnicoMasRapido;
    }
}

