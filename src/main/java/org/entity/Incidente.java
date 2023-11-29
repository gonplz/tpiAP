package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private LocalDate dateStart;
    private LocalDate dateEstimate;
    private LocalDate dateEnd;
    private String consideration;
//    @Column(name = "estado")
    private Estado state;
    //private int [] complejidad={1,2,3}; // normal media alta
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    public Incidente(String title, LocalDate dateStart, LocalDate dateEstimate, LocalDate dateEnd, String consideration, Estado state,Cliente cliente,Tecnico tecnico) {
        this.title = title;
        this.dateStart = dateStart;
        this.dateEstimate = dateEstimate;
        this.dateEnd = dateEnd;
        this.consideration = consideration;
        this.state = state;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

}
