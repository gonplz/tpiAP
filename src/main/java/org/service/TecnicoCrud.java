package org.service;

import org.entity.Tecnico;
import org.repository.CrudRepositorie;
import org.repository.TecnicoRepositorie;

import java.time.LocalDate;

public class TecnicoCrud implements TecnicoRepositorie {
    @Override
    public void create(Tecnico tecnico) {}

    @Override
    public void update(Tecnico tecnico) {}

    @Override
    public void delate(Tecnico tecnico) {}

    @Override
    public Tecnico retrive(int id) {
        return null;
    }

    @Override
    public Tecnico retriveAll() {
        return null;
    }

    @Override
    public Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin) {
        return null;
    }

    @Override
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
}
