package org.repository;

import org.entity.Tecnico;

import java.time.LocalDate;

public interface TecnicoRepositorie {

 Tecnico NumeroDeDias(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos en los ultimos N dias//
    Tecnico NumeroDeEspecial(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos por especialidad//
    Tecnico NumeroDeIncidentes(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien fue le tecnico con mas incidentes resueltos en menos tiempo//
    Tecnico tecnicoMasRapido(LocalDate inicio, LocalDate fin); // este metodo resuelve, quien es el tecnico mas rapido//


}
