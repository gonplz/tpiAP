package org.repository;

import org.entity.Especialidad;
import org.entity.Tecnico;

import java.time.LocalDate;

public interface TecnicoRepositorie extends CrudRepositorie<Tecnico> {

    Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin, Tecnico tecnico); // este método resuelve, quien fue el técnico con más incidentes resueltos en los últimos N días//
    Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin, Especialidad especialidad, Tecnico tecnico); // este método resuelve, quien fue el técnico con más incidentes resueltos por especialidad//
    Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin,Tecnico tecnico); // este método resuelve, quién es el técnico más rápido//

}
