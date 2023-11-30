package org.repository;

public class enCurso implements State {
    @Override
    public String cambiarIncidente() {
        return "En curso";
    }
}
