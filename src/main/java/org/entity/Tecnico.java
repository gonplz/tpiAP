package org.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private int dni;

//    private List<Incidente> incidentes;
    private Noti medio;

    public Tecnico(String firstname, String lastname, int dni, Noti medio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.medio = medio;
    }
}
