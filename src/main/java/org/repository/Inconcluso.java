package org.repository;

public class Inconcluso implements State {
    @Override
    public String cambiarIncidente() {
        return "Inconcluso";
    }
}
