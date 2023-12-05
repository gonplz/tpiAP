package org.app;

import org.entity.*;
import org.repository.enCurso;
import org.service.ClienteService;
import org.service.IncidenteService;
import org.service.TecnicoService;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
 *  ##############
 *  #            #
 *  #            #
 *  #            #
 *  #            #
 *  ##############
 * */


/*TODO Mejorar
   *implementar interfaz grafica
*  *Factorizar codigo
*  *Implementar observer para el email y mensaje
* *
*
*  */
public class menuApp {
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    menuApp() {
        super();
    }

    public static void main(String[] args) {

        // cliente sin id ni incidente

//       var cliente= crearCliente();
//        System.out.println(cliente);

//       var incidente=crearIncidente();
//        System.out.println(incidente);
//        List<Tecnico> listaTecnicos = new ArrayList<>();
//        TecnicoService tecnicoService = new TecnicoService();
//        Incidente incidente = new Incidente();
//        incidente.getRequiereEspecialidades().add(Especialidad.SAP);
//        incidente.getRequiereEspecialidades().add(Especialidad.MAC);
//
//        Tecnico tecnico = new Tecnico();
//        tecnico.agregarEspecialidad(Especialidad.SAP);
//        tecnico.agregarEspecialidad(Especialidad.MAC);
//
//        Tecnico tecnico2 = new Tecnico();
//        tecnico2.agregarEspecialidad(Especialidad.LINUX);
//        tecnico2.agregarEspecialidad(Especialidad.MAC); // Aquí corregido, cambié tecnico por tecnico2
//        listaTecnicos.add(tecnico);
//        listaTecnicos.add(tecnico2); // Aquí corregido, cambié tecnico por tecnico2
//
//        tecnicoService.filtrado(listaTecnicos, incidente)
//                .forEach(System.out::println);

          menu();
//        ClienteService cli=new ClienteService();
//        IncidenteService inci=new IncidenteService();
//        List<Especialidad>especialidades=inci.find(10).getRequiereEspecialidades();
//        Cliente cliente=cli.find(1);
//        cliente.cargarServicios(especialidades);
//        cli.update(cliente);

    }

    public static Cliente crearCliente() {
        String razonSocial;
        String CUIT;
        String email;
        System.out.println("Ingrese su razon social");
        razonSocial = sc.nextLine();
        System.out.println("Ingrese si CUIT");
        CUIT = sc.nextLine();
        System.out.println("Ingrese el email");
        email = sc.nextLine();
        return new Cliente(razonSocial, CUIT, email);

    }

    public static Tecnico crearTecnico() {
        Tecnico tecnico = new Tecnico();
        String nombre;
        String apellido;
        int dni;
        System.out.println("Ingrese el nombre del tecnico");
        nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del tecnico");
        apellido = sc.nextLine();
        System.out.println("Ingrese el dni del tecnico");
        dni = sc.nextInt();
        List<Especialidad> especialidades = SeleccionarEspecialidad();
        tecnico.setEspecialidades(especialidades);
        tecnico.setFirstname(nombre);
        tecnico.setLastname(apellido);
        tecnico.setDni(dni);
        tecnico.setMedio(Notificacion.EMAIL);
        return tecnico;
    }
    //TODO terminar
    private static Notificacion metodoContacto() {

        int op;
        Notificacion contacto=null;
        do{
            for(int i = 1; i< Notificacion.values().length; i++){
                Notificacion formaContacto = Notificacion.values()[i - 1];
                System.out.println(i + ". " + formaContacto);
                op=sc.nextInt();
                if( (op< Notificacion.values().length-1) && op>0 ){
                    contacto= Notificacion.values()[op];
                }

            }
        }while(contacto==null);
        return contacto;
    }

    private static List<Especialidad> SeleccionarEspecialidad() {
        int opc;
        List<Especialidad> listaEspecialiades = new ArrayList<>();
        do {
            System.out.println(Especialidad.values().length);
            System.out.println("Menú de especialidades:");
            for (int i = 1; i <= Especialidad.values().length; i++) {
                Especialidad especialidad = Especialidad.values()[i - 1];
                System.out.println(i + ". " + especialidad);
            }
            System.out.println((Especialidad.values().length + 1) + ". Salir");

            System.out.print("Seleccione una especialidad: ");
            opc = sc.nextInt();
            sc.nextLine();
            System.out.println(opc);
            if (opc != Especialidad.values().length + 1 &&
                    !(listaEspecialiades.contains(Especialidad.values()[opc - 1]))) {
                listaEspecialiades.add(Especialidad.values()[opc - 1]);
            }
        } while (opc != Especialidad.values().length + 1);
        return listaEspecialiades;


    }

    public static Incidente crearIncidente() {
        Incidente incidente = new Incidente();
        //Scanner sc=new Scanner(System.in);
        String titulo;
        int ano;
        int mes;
        int dia;
        String consideraciones;
        LocalDate tiempoEstimado;
        System.out.println("Ingrese titulo a su problema");
        titulo = sc.nextLine();
        System.out.println("ingrese una descripcion al problema");
        consideraciones = sc.nextLine();
        System.out.println("Ingrese el ano para el tiempo estimado");
        ano = sc.nextInt();
        System.out.println("Ingrese el mes para el tiempo estimado");
        mes = sc.nextInt();
        System.out.println("Ingrese el dia para el tiempo estimado");
        dia = sc.nextInt();
        tiempoEstimado = LocalDate.of(ano, mes, dia);
        incidente.setTitle(titulo);
        incidente.setConsideration(consideraciones);
        incidente.setDateEstimate(tiempoEstimado);
        incidente.setDateStart(LocalDate.now());
        List<Especialidad> esp = SeleccionarEspecialidad();
        for (Especialidad e : esp) {
            System.out.println(e);
        }
        incidente.setRequiereEspecialidades(esp);
        return incidente;


    }


    //MenuApp

    public static void menu() {
        int opc;
        TecnicoService servicioTecnico = new TecnicoService();
        do {

            System.out.println("Menu");
            System.out.println("1.Area comercial");
            System.out.println("2.Mesa ayuda");
            System.out.println("3.RRHH");
            System.out.println("4.Area tecnicos");
            System.out.println("5.salir");
            System.out.println("Seleccione una opcion: ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Area comercial");
                    subMenuCliente();
                    break;
                case 2:
                    System.out.println("mesa ayuda");
                    mesaAyuda();
                    break;
                case 3:
                    System.out.println("submenu rrhh");
                    rrhh();
                    break;
                case 4:
                    System.out.println("submenu tecnicos");
                    menuTecnicos();
                    break;
                default:
                    System.out.println("No ha seleccionado ninguna opcion valida");
                    break;


            }

        } while (opc != 5);
        sc.close();
    }

    public static void subMenuCliente() {
        int opc;

        IncidenteService incidenteService = new IncidenteService();

        try(ClienteService serviceCliente = new ClienteService();){

            do {
                System.out.println("1.Registrar Cliente");
                System.out.println("2.Eliminar Cliente");
                System.out.println("3.Actualizar Cliente");
                System.out.println("4.Buscar Clientes");
                System.out.println("5.listar Clientes ");
                System.out.println("6.Volver al menu");
                System.out.println("Seleccione una opcion: ");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        // buscar cliente ->
                        // si cliente existe -> registrar incidente ->asignar tecnico
                        // sino crear cliente -> crear cliente -registrar incidente -> asignar tecnico
                        try {
                            Cliente cliente = crearCliente();
                            serviceCliente.create(cliente);

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                        break;
                    case 2:
                        // elimina un cliente->elimina un incidente
                        Cliente c3 = serviceCliente.find(1);
                        serviceCliente.delete(c3);
                        break;
                    case 3:
                        // actualiza un cliente
                        sc.nextLine();
                        String cuit;
                        System.out.println("*Nota solo se actualizara informacion personal del cliente"
                                + "\n" + "Ingrese el CUIT del cliente");
                        cuit = sc.nextLine();
                        Cliente clienteRecuperado=serviceCliente.findByCUIT(cuit);
                        int idCliente;
                        if(clienteRecuperado!=null){
                            idCliente=clienteRecuperado.getId();
                            Cliente c2 = crearCliente();
                            c2.setId(idCliente);
                            serviceCliente.update(c2);
                        }
                        break;
                    case 4:
                        // busca un cliente
                        sc.nextLine();
                        String CUIT;
                        System.out.println("Ingrese el CUIT de el cliente");
                        CUIT = sc.nextLine();
                        Cliente aux = serviceCliente.findByCUIT(CUIT);
                        System.out.println(aux);
                        break;
                    case 5:
                        // lista de clientes
                        List<Cliente> listaClientes = serviceCliente.findAll();
                        listaClientes.forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("volviendo al menu principal");
                        break;
                    case 7:
                        sc.nextLine();
                        String c;
                        System.out.println("Ingrese el CUIT de el cliente");
                        c = sc.nextLine();
                        Cliente aux2 = serviceCliente.findByCUIT(c);
                        System.out.println(aux2.getIncidente().getRequiereEspecialidades());
                        break;
                    default:
                        System.out.println("No ha seleccionado ninguna opcion valida");
                        break;
                }


            } while (opc != 6);



        }catch (Exception e){
            e.printStackTrace();

        }





    }

    public static void rrhh() {
        int opc;
        try(TecnicoService tecnicoService=new TecnicoService();){

            do {
                System.out.println("1.Registrar Tecnico");
                System.out.println("2.Eliminar Tecnico");
                System.out.println("3.Actualizar Tecnico");
                System.out.println("4.Buscar Tecnico");
                System.out.println("5.lista de Tecnicos ");
                System.out.println("6.mostrar reportes");
                System.out.println("7.Volver al menu");
                System.out.println("Seleccione una opcion: ");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        sc.nextLine();
                        Tecnico tecnico = crearTecnico();
                        tecnicoService.create(tecnico);
                        break;
                    case 2:
                        //eliminar
                        sc.nextLine();
                        int doc;
                        System.out.println("Ingrese el documento del cliente a borrar");
                        doc=sc.nextInt();
                        Tecnico tecAux= tecnicoService.findByDni(doc);
                        if(tecAux!=null){
                            for(Incidente incidente:tecAux.getListaIncidentes()){
                                incidente.setTecnico(null);

                            }
                            tecAux.getListaIncidentes().clear();
                            tecAux.getReporte_incidentes().clear();
                            tecnicoService.delete(tecAux);


                        }else{
                            System.out.println("No fue posible borrar");
                        }
                        break;


                    case 3:
                        // actualizar
//                    sc.nextLine();
                        int documento;
                        System.out.println("*Nota solo se actualizara informacion del tecnico no del incidente"
                                + "\n" + "Ingrese el Dni del tecnico");
                        documento = sc.nextInt();
                        int id = tecnicoService.findByDni(documento).getId();
                        sc.nextLine();
                        Tecnico t2= crearTecnico();
                        t2.setId(id);
                        tecnicoService.update(t2);
                        break;

                    case 4:
                        // buscar tecnico
                        int dni;
                        System.out.println("Ingrese el dni del tecnico");
                        dni=sc.nextInt();
                        Tecnico tec=tecnicoService.findByDni(dni);
                        //System.out.println(tec);
                        tec.mostrarIncidentes();
                        break;
                    case 5:
                        // lista tecnicos
                        for(Tecnico t: tecnicoService.findAll()){
                            System.out.println(t);
                        }
                        break;
                    case 6:
                        //generar reporte
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("No ha ingresado un numero correcto");
                        break;


                }

            } while (opc != 7);



        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static void mesaAyuda() {
        int opc;
        try(TecnicoService tecnicoService = new TecnicoService();
          ClienteService clienteService=new ClienteService();
          IncidenteService incidenteService=new IncidenteService();){
            do {
                System.out.println("1.Registrar Problema");
                System.out.println("2.Asignar Tecnico");
                System.out.println("3.Servicios Contratados por el cliente");
                System.out.println("Seleccione una opcion: ");
                opc=sc.nextInt();
                switch (opc) {
                    case 1:
                        //registrar incidente , que especialidad contratar
                        // busca tecnicos el tipo de problemas
                        sc.nextLine();
                        String CUIT;
                        System.out.println("Ingrese el CUIT de el cliente");
                        CUIT = sc.nextLine();
                        Cliente aux = clienteService.findByCUIT(CUIT);
                        System.out.println(aux);
                        if(aux!=null){
                            System.out.println("cliente encontrado->\n"+aux);
                            Incidente incidente = crearIncidente();
                            incidente.setCliente(aux);
                            aux.setIncidente(incidente);
                            incidenteService.create(incidente);
                        }

                        break;
                    case 2: //asignar tecnico al incidente
                        int id;
                        System.out.println("Ingrese el id del incidente");
                        id= sc.nextInt();
                        Incidente incidente2=incidenteService.find(id);
                        var listaTecnicos=tecnicoService.findAll();
                        var tec=tecnicoService.filtrado(listaTecnicos,incidente2);
                        if(tec!=null){
                            tec.forEach(System.out::println);
                            int idTecnico;
                            System.out.println("Ingrese el id del tecnico a contratar");
                            idTecnico= sc.nextInt();
                            Tecnico tecnico=tecnicoService.find(idTecnico);
                            System.out.println("el estado es"+ incidente2.getEstado());
                            if(incidente2.getEstado().equals("Inconcluso")){
                                System.out.println(":DDDDDD ||| ");
                                tecnicoService.asignarIncidente(tecnico,incidente2);
                                incidente2.setEstado(new enCurso());
                                incidente2.setTecnico(tecnico);
                                Cliente cl1=incidente2.getCliente();
                                cl1.setIncidente(incidente2);
                                clienteService.cargarServicios(incidente2.getRequiereEspecialidades(),cl1);
                                incidenteService.update(incidente2);
                                System.out.println("notificar al tecnico");
                            }else{
                                System.out.println("No se puedo asignar el tecnico ");
                            }


                        }

                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("3.Servicios contratados del cliente");
                        String CUIT2;
                        System.out.println("Ingrese el CUIT del cliente");
                        CUIT2=sc.nextLine();
                        var cli2=clienteService.findByCUIT(CUIT2);
                        System.out.println("CUIT "+cli2.getCuit()+" Email:"+cli2.getEmail()+"\n"
                                   + "servicios "+ cli2.getServiciosContratados()+ "razon social"+ cli2.getRazonSocial()
                        );
                        break;
                    case 5:
                        System.out.println("Volviendo al menu principal");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");

                }
            }while(opc!=4);

        }catch (Exception e){
            e.printStackTrace();

        }


    }
    public  static void menuTecnicos(){
        IncidenteService incidenteService=new IncidenteService();
        TecnicoService tecnicoService=new TecnicoService();
        int opc;
        System.out.println("Seleccione una opcion del menu");
        System.out.println("1.Concluir Incidente ");
        System.out.println("2.Darse de baja del incidente");
        opc=sc.nextInt();
        switch (opc){
            case 1:
                int dni;
                System.out.println("ingrese su dni");
                dni=sc.nextInt();
                Tecnico tecnico=tecnicoService.findByDni(dni);
                tecnico.getListaIncidentes().stream()
                        .map(TecnicoService::incidentesTecnico)
                        .collect(Collectors.toList())
                        .forEach(System.out::println);

                String recomendaciones;
                System.out.println("Escriba una recomendaciones al cliente para " +
                        "evitar posibles incidentes");
                System.out.println("1.Incon");
                break;
        }
    }

}
