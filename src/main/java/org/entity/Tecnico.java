package org.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private int dni;
    private Especialidad especialidad;
    private Noti medio;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
     private Set<Incidente> problema = new HashSet<>();

    public Tecnico(String firstname,String lastname,int dni,Especialidad especialidad,Noti medio,Set<Incidente>problema) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.especialidad = especialidad;
        this.medio = medio;
        this.problema = problema;
    }

    //Metodo add//
    public void addIncidentes (Incidente incidente) {
        problema.add(incidente);
    }
}
