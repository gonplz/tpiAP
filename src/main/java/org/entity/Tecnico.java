package org.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
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
     private Set<Incidente> incidentes = new HashSet<>();

    public Tecnico(String firstname, String lastname, int dni, Noti medio) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.medio = medio;
    }

    //Metodo add//
    public void addIncidentes (Incidente incidente) {
        incidente.setTecnico(this);
        incidentes.add(incidente);
    }

}
