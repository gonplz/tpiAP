package org.entity;

import lombok.*;
import org.repository.Inconcluso;
import org.repository.State;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString(exclude = {"cliente","state","reporte_tecnicos"})

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
    @Transient
    private int [] complejidad={1,2,3}; // normal media alta

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @Column(columnDefinition = "VARCHAR(255)")
    @ElementCollection(targetClass = Especialidad.class,fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Especialidad> requiereEspecialidades=new ArrayList<>();

    @ManyToMany(mappedBy = "reporte_incidentes")
    private List<Tecnico> reporte_tecnicos= new ArrayList<>();
    public Incidente() {
        this.state=new Inconcluso();
        setEstado(this.state);

    }

    public void setEstado(State state){
        this.estado=state.cambiarIncidente();

    }

//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//        if (cliente != null && !cliente.getIncidentes().contains(this)) {
//            cliente.getIncidentes().add(this);
//        }
//    }

}
