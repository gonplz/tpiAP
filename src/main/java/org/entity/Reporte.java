package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Transient
//    @JoinColumn(name = "incidente_id")
    private Incidente incidente;

 @Transient
//    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    public Reporte(Incidente incidente ,Tecnico tecnico) {
        this.incidente = incidente;
        this.tecnico = tecnico;
    }
}
