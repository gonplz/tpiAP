package org.service;

import org.entity.Tecnico;
import org.repository.CrudRepositorie;

public class TecnicoCrud implements CrudRepositorie<Tecnico> {
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
}
