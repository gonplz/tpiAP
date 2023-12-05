package org.service;

import org.entity.Cliente;
import org.entity.Especialidad;
import org.repository.ClasePersistencia;
import org.repository.CrudRepositorie;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class ClienteService implements CrudRepositorie<Cliente>,AutoCloseable {

    private EntityManager em;


    public ClienteService() {
        this.em =ClasePersistencia.EntityManejador();
    }

    @Override
    public void create(Cliente cliente) {
        //EntityManager em= ClasePersistencia.EntityManejador();
        try{
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }


    }

    @Override
    public void update(Cliente cliente) {

        try{
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }


    }

    @Override
    public void delete(Cliente cliente) {
        try{
            Objects.requireNonNull(cliente);
            if(cliente.getId()>0){
                em.getTransaction().begin();
                em.remove(cliente);
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
    public Cliente find(int id) {
       // EntityManager em= ClasePersistencia.EntityManejador();
        Cliente clienteRecuperdado=null;
        try {
            clienteRecuperdado = em.find(Cliente.class,id);

            if ( clienteRecuperdado != null) {
                System.out.println("Cliente recuperado: " +  clienteRecuperdado);
            } else {
                System.out.println("Cliente no encontrado con el ID: " +id);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return clienteRecuperdado;



    }
    public Cliente findByCUIT(String  CUIT){
        Cliente cliente=null;
        try {
            // inseguro posible inyeccion sql
            //  obj= em.createQuery("SELECT c FROM Cliente c WHERE c.cuit="+CUIT).getSingleResult();
            Query query=em.createQuery("SELECT c FROM Cliente c WHERE c.cuit = :cuit");
            query.setParameter("cuit",CUIT);
            cliente=(Cliente) query.getSingleResult();

        }catch (NoResultException e){
            System.out.println("Cliente no encontrado con el Dni: " +CUIT);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return cliente;

    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente>listaClientes=null;
        try{
            listaClientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return listaClientes;


    }

    public void cargarServicios(List<Especialidad>listaEspecialidades,Cliente cliente){
        cliente.getServiciosContratados().clear();
        cliente.getServiciosContratados().addAll(listaEspecialidades);

    }

    /*AutoClosable la interfaz permite el cerrado automatico de recursos
    * */
    @Override
    public void close() throws Exception {
        if(em!=null && em.isOpen()){
            em.close();
        }
    }
}
