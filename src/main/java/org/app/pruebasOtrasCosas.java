package org.app;

import java.util.ArrayList;
import java.util.List;

public class pruebasOtrasCosas {
    public static void main(String[] args) {
        List<String> nombres=new ArrayList<>();
        nombres.add("Franciso");
        nombres.add("Diego");

        System.out.println("------Comienzo");
        nombres.forEach(System.out::println);
        System.out.println("------Despues");
        nombres.removeIf(name->name.equals("Franciso"));
        nombres.forEach(System.out::println);
    }


}
