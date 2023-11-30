package org.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

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

    private Noti medio;

     @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
     private Set<Incidente> problema = new HashSet<>();

    @Column(columnDefinition = "VARCHAR(255)")
    @ElementCollection(targetClass = Especialidad.class)
    @Enumerated(EnumType.STRING)
    private List<Especialidad> especialidades;


    public Tecnico(String firstname,String lastname,int dni,Noti medio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dni = dni;
        this.medio = medio;

    }

    public void agregarEspecialidad(Especialidad especialidad) {
        if (especialidades == null) {
            especialidades = new ArrayList<>();
        }
        especialidades.add(especialidad);
    }

    public void mostrasEspecialidades(){
      if(this.especialidades!=null){
          this.especialidades.forEach(System.out::println);
      }
    }

    public void eliminarEspecialidad(Especialidad especialidad){
        Objects.requireNonNull(this.especialidades);
        this.especialidades.removeIf(e->e.equals(especialidad));
    }

//    public void mostrarIndicidentesAsignados(){
//        Objects.requireNonNull(this.problema,"No esta inicialiazado");
//        if(this.problema.size()>0 ){
//            this.problema.forEach(System.out::println);
//        }
//    }


}
