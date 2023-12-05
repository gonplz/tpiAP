package org.app;

import org.entity.Incidente;
import org.service.TecnicoService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class pruebasOtrasCosas {
    public static void main(String[] args) {
//        List<String> nombres=new ArrayList<>();
//        nombres.add("Franciso");
//        nombres.add("Diego");
//
//        System.out.println("------Comienzo");
//        nombres.forEach(System.out::println);
//        System.out.println("------Despues");
//        nombres.removeIf(name->name.equals("Franciso"));
//        nombres.forEach(System.out::println);
//        List<String>frutas=new ArrayList<>();
//        frutas.add("banana");
//        frutas.add("pera");
//        frutas.add("damasco");
//        List<String>frutas2=new ArrayList<>();
//        frutas2.add("kiwi");
//
//        boolean contieneTodas = new HashSet<>(frutas).containsAll(frutas2);
//        System.out.println(contieneTodas);
//        Incidente incidente=menuApp.crearIncidente();
//        System.out.println(incidente.getEstado());

        TecnicoService tecnicoService=new TecnicoService();
        tecnicoService.notificar("tienes un incidente nuevo registrado","baridonfrancisco@gmail.com");


    }


}
