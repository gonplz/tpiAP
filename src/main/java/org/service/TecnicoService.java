package org.service;




import org.entity.Incidente;
import org.entity.Tecnico;
import org.repository.ClasePersistencia;
import org.repository.TecnicoRepositorie;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class TecnicoService implements TecnicoRepositorie,AutoCloseable {

    private EntityManager em;

    public TecnicoService(){
        this.em =ClasePersistencia.EntityManejador();
    }

    @Override
    public void create(Tecnico tecnico) {
        try{
            em.getTransaction().begin();
            em.persist(tecnico);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }


    }

    @Override
    public void update(Tecnico tecnico) {
        try{
            em.getTransaction().begin();
            em.merge(tecnico);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

    }

    @Override
    public void delete(Tecnico tecnico) {
        try{
            Objects.requireNonNull(tecnico);
            if(tecnico.getId()>0){
                em.getTransaction().begin();
                em.remove(tecnico);
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
    public Tecnico find(int id) {

       Tecnico tecnicoRecuperado=null;
        try {
            tecnicoRecuperado = em.find(Tecnico.class,id);
            if(tecnicoRecuperado==null){
                System.out.println("No se ha encontrado al tecnico");
            }

        } catch (Exception e){
            e.printStackTrace();

        }
        return tecnicoRecuperado;



    }

    public Tecnico findByDni(int dni){
        Tecnico tecnico=null;
        try {
            Query query=em.createQuery("SELECT t FROM Tecnico t WHERE t.dni = :dni");
            query.setParameter("dni",dni);
            tecnico=(Tecnico) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Tecnico no encontrado con el Dni: " +dni);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return tecnico;

    }

    @Override
    public List<Tecnico> findAll() {
        List<Tecnico>listaTecnicos=null;
        try{
            listaTecnicos = em.createQuery("SELECT t FROM Tecnico t", Tecnico.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return listaTecnicos;
    }

    public void traerReporte(int id){
        List<Incidente>reporteIncidentes=null;
        try{
           Query query=em.createQuery("SELECT i FROM Incidente i WHERE i.cliente_id=:cliente_id");
           query.setParameter("id_cliente",id);
           reporteIncidentes=query.getResultList();

        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Override
    public Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin) {
        return null;
    }


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


    public List<Tecnico> filtrado(List<Tecnico>lista,Incidente registro){
        return lista.stream().
                filter(e-> new HashSet<>(e.getEspecialidades()).containsAll(registro.getRequiereEspecialidades()))
                .collect(Collectors.toList());

    }

    public void asignarIncidente(Tecnico tecnico,Incidente incidenteBuscado){
        if(incidenteBuscado.getEstado().equals("Inconcluso")){
            tecnico.getListaIncidentes().add(incidenteBuscado);
        }else{
            System.out.println("Error al asignar un incidente");
        }
    }

    public void notificar(String mensaje,String direccion) {

        try{
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "25");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            String username = "baridonfrancisco03@gmail.com";
            String password = "";


            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            //new InternetAddress(direccion)
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(direccion));
            message.setSubject("Nuevo Incidente");
            message.setText(mensaje);
            Transport.send(message);
        }catch (MessagingException e){
            e.printStackTrace();


        }


    }

    public static String incidentesTecnico(Incidente incidente){
        return "Incidente{" +
                "id=" + incidente.getId() +
                ", title=" + incidente.getTitle() +
                ", dateStart=" + incidente.getDateStart() +
                ", dateEstimate=" + incidente.getDateEstimate() +
                ", dateEnd=" + incidente.getDateEnd() +
                ", consideration=" + incidente.getConsideration()+
                ", estado=" + incidente.getEstado() +
                ", cliente=" + incidente.getCliente().getId() +
                ", requiereEspecialidades=" + incidente.getRequiereEspecialidades() +
                ", reporte_tecnicos=" + incidente.getReporte_tecnicos() +
                '}'+"\n";
    }

    // filtrar la lista de incidente de cada tecnico xp
    public void tecnicosMasIncidentesR(int nDias){
      List<Tecnico>listaTecnicos=findAll();
      // ultimos n dias (diasActuales-nDias0
        LocalDate tiempo=LocalDate.now().minusDays(nDias);
        Optional<Tecnico> tecnicoConMasIncidentes = listaTecnicos.stream()
                .max(Comparator.comparingLong(tecnico ->
                        tecnico.getListaIncidentes().stream()
                                .filter(incidente -> incidente.getEstado().equals("Encurso"))
                                .filter(incidente -> incidente.getDateEnd().isAfter(tiempo))
                                .count()
                ));
         tecnicoConMasIncidentes.orElseThrow();


    }




    @Override
    public void close() throws Exception {
        if(em!=null && em.isOpen()){
            em.close();
        }
    }

}
