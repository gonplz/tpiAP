package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private LocalDate date;
    private LocalDate dateEstimate;
    private LocalDate dateResolution;
    private String consideration;
    private Estado state;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Incidente(String title, LocalDate date, LocalDate dateEstimate, LocalDate dateResolution, String consideration, Estado state, Cliente cliente) {
        this.title = title;
        this.date = date;
        this.dateEstimate = dateEstimate;
        this.dateResolution = dateResolution;
        this.consideration = consideration;
        this.state = state;
        this.cliente = cliente;
    }
}
