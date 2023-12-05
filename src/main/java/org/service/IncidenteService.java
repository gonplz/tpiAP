package org.service;


import org.entity.Incidente;
import org.repository.ClasePersistencia;
import org.repository.CrudRepositorie;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class IncidenteService implements CrudRepositorie<Incidente>,AutoCloseable {

    private EntityManager em;
    public IncidenteService(){
        this.em=ClasePersistencia.EntityManejador();
    }
    @Override
    public void create(Incidente incidente) {
        try{
            em.getTransaction().begin();
            em.persist(incidente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

    }

    @Override
    public void update(Incidente incidente) {
        try{
            em.getTransaction().begin();
            em.merge(incidente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }


    }

    @Override
    public void delete(Incidente incidente) {
        try{
            Objects.requireNonNull(incidente);
            if(incidente.getId()>0){
                em.getTransaction().begin();
                em.remove(incidente);
                em.getTransaction().commit();
            }
        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public Incidente find(int id) {
        Incidente incidenteRecuperado=null;
        try {
            incidenteRecuperado = em.find(Incidente.class,id);
            if(incidenteRecuperado==null){
                System.out.println("No se ha encontrado al incidente");
            }

        } catch (Exception e){
            e.printStackTrace();

        }
        return incidenteRecuperado;




    }

    @Override
    public List<Incidente> findAll() {
        List<Incidente>listaIncidentes=null;
        try{
            listaIncidentes = em.createQuery("SELECT i FROM Incidente i", Incidente.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return listaIncidentes;
    }

    @Override
    public void close() throws Exception {
        if(em!=null && em.isOpen()){
            em.close();
        }
    }
}
