package org.app;

import org.entity.*;
import org.repository.ClasePersistencia;
import org.repository.enCurso;
import org.service.ClienteService;
import org.service.IncidenteService;
import org.service.TecnicoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



        // Crear un nuevo cliente, incidente y tecnico
//        Cliente cliente = new Cliente();
//        cliente.setRazonSocial("Francisco");
//        cliente.setCuit("1034");
//        cliente.setIncidentes(new HashSet<>());
//         ClienteService servicioCliente=new ClienteService();
//       servicioCliente.create(cliente);
//        Cliente recuperado=servicioCliente.retrive(1);

        TecnicoService service=new TecnicoService();
        var tecnicoBase=service.retrive(4);
//        //service.create(tec1);
//        System.out.println(tecnicoBase);
//        //Crear un incidente
//        Incidente incidente = new Incidente();
//        incidente.setCliente(recuperado);
//        incidente.setDateStart(LocalDate.now());
//        incidente.setDateEstimate(LocalDate.now());
//        incidente.setDateEnd(LocalDate.now());
//        incidente.setConsideration("XXXXXXX");
//        incidente.setTitle("Mantenimiento");
//        incidente.setEstado(new enCurso());
//       // incidente.setTecnico(tecnicoBase);
//        System.out.println("-----");
//        IncidenteService servicioIncidente=new IncidenteService();
       // servicioIncidente.create(incidente);
        System.out.println(tecnicoBase);




        // insertar tecnico

//        Tecnico tecnico = new Tecnico();
//        tecnico.setFirstname("Vero");
//        tecnico.setLastname("Galvi");
//        tecnico.setDni(2026);
//        tecnico.agregarEspecialidad(Especialidad.LINUX);
//        tecnico.agregarEspecialidad(Especialidad.SAP);
//        tecnico.setMedio(Noti.WHATSAPP);
//        tecnico.setProblema(new HashSet<>());
//        insert(tecnico);

//        Tecnico tecnico = new Tecnico();
//        tecnico.setFirstname("Diego");
//        tecnico.setLastname("Ginard");
//        tecnico.setDni(92);
//        tecnico.setId(2);
//        tecnico.agregarEspecialidad(Especialidad.LINUX);
//        tecnico.agregarEspecialidad(Especialidad.MAC);
//        tecnico.agregarEspecialidad(Especialidad.TANGO);
//        tecnico.setMedio(Noti.WHATSAPP);


//        TecnicoService serviceTecnico=new TecnicoService();
//        serviceTecnico.create(tecnico);

//        serviceTecnico.update(tecnico);

         //recuperar tecnico
//        var valor=buscarTecnico(1);
//        System.out.println(valor);

        //recuperar tecnico
//
//        Incidente incidente = new Incidente();
//        incidente.setCliente(cliente);
//        incidente.setDateStart(LocalDate.now());
//        incidente.setDateEstimate(LocalDate.now());
//        incidente.setDateEnd(LocalDate.now());
//        incidente.setConsideration("XXXXXXX");
//        incidente.setTitle("Mantenimiento");
//        incidente.setState(Estado.ESTADO_PROCESO);
//        incidente.setTecnico(tecnico);
//
//
////        tecnico.addIncidentes(incidente);



    }


    //MenuApp

    public static void menu(){
        int opc;
        Scanner sc=new Scanner(System.in);
        TecnicoService servicioTecnico=new TecnicoService();
        do{

            System.out.println("Menu");
            System.out.println("1.Cliente");
            System.out.println("2.Tecnico");
            System.out.println("3.Incidente");
            System.out.println("4.Salir");
            System.out.println("Seleccione una opcion: ");
            opc=sc.nextInt();
            switch (opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;


            }

        }while (opc!=4);

    }
    public static void subMenuCliente(){
        int opc;
        Scanner sc=new Scanner(System.in);
        do{

            System.out.println("1.Crear Cliente");
            System.out.println("2.Eliminar Cliente");
            System.out.println("3.Actualizar Cliente");
            System.out.println("4.Buscar Clientes");
            System.out.println("5.listar Clientes ");
            System.out.println("5.Servicios contratados del cliente");
            System.out.println("6.Volver al menu");
            System.out.println("Seleccione una opcion: ");
            opc=sc.nextInt();
            switch (opc){
                case 1:
                    String razonSocial;
                    String CUIT;
                    System.out.println("Ingrese su razon social");
                    razonSocial=sc.nextLine();
                    System.out.println("Ingrese si CUIT");
                    CUIT=sc.nextLine();
                    break;
                case 2:
                    // elimina un cliente
                    break;
                case 3:
                    // actualiza un cliente
                    break;
                case 4:
                    // busca un cliente
                    break;
                case 5:
                    // lista un cliente
                    break;
                case 6:
                    System.out.println();
                    break;
                default:
                    break;
            }


        }while(opc!=6);



    }


}






