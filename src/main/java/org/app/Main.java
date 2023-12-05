package org.app;


import org.entity.Cliente;
import org.entity.Incidente;
import org.service.ClienteService;
import org.service.IncidenteService;
import org.service.TecnicoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();


//        Cliente gonza=new Cliente();
//        gonza.setCuit("123123");
//        gonza.setRazonSocial("Arcor_SA");
//        gonza.setIncidentes(new HashSet<>());
//        serviceCliente.create(gonza);
//        Cliente cliente=serviceCliente.retrive(1);
//        System.out.println(cliente);

//      TecnicoService tecnicoService=new TecnicoService();
//        Tecnico tecnico = new Tecnico();
//        tecnico.setFirstname("Diego");
//        tecnico.setLastname("Ginard");
//        tecnico.setDni(92);
//        tecnico.agregarEspecialidad(Especialidad.LINUX);
//        tecnico.agregarEspecialidad(Especialidad.MAC);
//        tecnico.agregarEspecialidad(Especialidad.TANGO);
//        tecnico.setMedio(Noti.WHATSAPP);
//        tecnicoService.create(tecnico);
//
//       var t1=tecnicoService.retrive(1);
//        System.out.println(t1);

//       IncidenteService incidenteService=new IncidenteService();
//        Incidente incidente = new Incidente();
//        incidente.setCliente(cliente);
//        incidente.setDateStart(LocalDate.now());
//        incidente.setDateEstimate(LocalDate.now());
//        incidente.getRequiereEspecialidades().add(Especialidad.TANGO);
//        incidente.setDateEnd(LocalDate.now());
//        incidente.setConsideration("XXXXXXX");
//        incidente.setTitle("Mantenimiento");
//        incidente.setEstado(new Inconcluso());
//        incidente.setTecnico(t1);
//        incidenteService.create(incidente);
//        var te=incidenteService.retrive(1);
//        System.out.println(te);


//        for(Incidente i:incidenteService.retriveAll()){
//            System.out.println(i.getTecnico().getProblema());
//        }





//
//
//        Cliente diego=new Cliente();
//        diego.setCuit("11233");
//        diego.setRazonSocial("asd23");
//        diego.setIncidentes(new HashSet<>());
//
//
//        serviceCliente.create(diego);
//        for(Cliente c:serviceCliente.retriveAll()){
//            System.out.println(c);
//        }



    }





}






