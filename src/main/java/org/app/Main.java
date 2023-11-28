package org.app;

import org.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) {

        // Crear un nuevo cliente, incidente y tecnico
        Cliente cliente = new Cliente();
        cliente.setRazonSocial("Fran");
        cliente.setCuit("2201");
        cliente.setIncidentes(new HashSet<>());

        Tecnico tecnico = new Tecnico();
        tecnico.setFirstname("Vero");
        tecnico.setLastname("Galvi");
        tecnico.setDni(2026);
        tecnico.setEspecialidad(Especialidad.SAP);
        tecnico.setMedio(Noti.WHATSAPP);
        tecnico.setProblema(new HashSet<>());

        Incidente incidente = new Incidente();
        incidente.setCliente(cliente);
        incidente.setDateStart(LocalDate.now());
        incidente.setDateEstimate(LocalDate.now());
        incidente.setDateEnd(LocalDate.now());
        incidente.setConsideration("XXXXXXX");
        incidente.setTitle("Mantenimiento");
        incidente.setState(Estado.ESTADO_PROCESO);
        incidente.setTecnico(tecnico);


//        tecnico.addIncidentes(incidente);

        insert(cliente);
        insert(tecnico);
        insert(incidente);

    }
    public static void insert(Object object){

        // Crear el EntityManagerFactory usando la unidad de persistencia definida en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar la transacción
            em.getTransaction().begin();

            // Persistir el cliente en la base de datos (esto también creará la tabla si no existe)
            em.persist(object);

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






//
//    public static void menu(){
//        int opc=5;
//        Scanner sc=new Scanner(System.in);
//
//        do{
//
//            System.out.println("Menu");
//            System.out.println("Mesa ayuda");
//            System.out.println("RRHHH");
//            System.out.println("Area administrativa");
//            System.out.println("5-Salir");
//
//            switch (opc){
//                case 1:
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//
//
//            }
//
//        }while (opc!=5);
//
//    }