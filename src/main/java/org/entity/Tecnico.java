package org.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

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
    List<Especialidad>especialidades;
    private List<Incidente> incidentes;
    private Noti medio;

    public Tecnico(String firstname, String lastname, int dni, Noti medio) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.medio = medio;
    }
}
