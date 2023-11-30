package org.service;

import org.entity.Reporte;
import org.repository.CrudRepositorie;

import java.util.List;

public class ReporteCrud implements CrudRepositorie<Reporte> {


    @Override
    public void create(Reporte reporte) {}

    @Override
    public void update(Reporte reporte) {}

    @Override
    public void delete(Reporte reporte) {}

    @Override
    public Reporte retrive(int id) {
        return null;
    }

    @Override
    public List<Reporte> retriveAll() {
        return null;
    }
}
