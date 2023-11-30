package org.repository;

public class Finalizado implements State {
    @Override
    public String cambiarIncidente() {
        return "Finalizado";
    }
}
