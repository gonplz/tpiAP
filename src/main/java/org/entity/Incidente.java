package org.entity;

import lombok.*;
import org.repository.State;
import org.repository.enCurso;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
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
    @Transient
    private State state;

    @Column(name = "Estado")
    private String estado;
    //private int [] complejidad={1,2,3}; // normal media alta

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @Column(columnDefinition = "VARCHAR(255)")
    @ElementCollection(targetClass = Especialidad.class)
    @Enumerated(EnumType.STRING)
    private List<Especialidad> requiereEspecialidades=new ArrayList<>();

    public Incidente(String title, LocalDate dateStart, LocalDate dateEstimate, LocalDate dateEnd, String consideration,Cliente cliente, Tecnico tecnico) {
        this.state=new enCurso();
        setEstado(this.state);
        this.title = title;
        this.dateStart = dateStart;
        this.dateEstimate = dateEstimate;
        this.dateEnd = dateEnd;
        this.consideration = consideration;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    public void setEstado(State state){

        this.estado=state.cambiarIncidente();
    }

}
