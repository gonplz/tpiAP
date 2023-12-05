package org.entity;
import lombok.*;
import javax.persistence.*;
import java.util.*;


@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @Column(name = "dni",unique = true)
    private int dni;
    private Notificacion medio;
                                              // sujeto a cambios ,cascade = CascadeType.ALL
     @OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER,orphanRemoval = true)
     private List<Incidente> listaIncidentes = new ArrayList<>();

    @Column(columnDefinition = "VARCHAR(255)")
    @ElementCollection(targetClass = Especialidad.class)
    @Enumerated(EnumType.STRING)
    private List<Especialidad> especialidades=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "reportes",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "incidente_id"))
    List<Incidente>reporte_incidentes=new ArrayList<>();

    public Tecnico(String firstname, String lastname, int dni, Notificacion medio) {
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
    public void quitarIncidente(Incidente incidente){
        Objects.requireNonNull(this.especialidades);
        listaIncidentes.remove(incidente);
    }

    public void eliminarEspecialidad(Especialidad especialidad){
        Objects.requireNonNull(this.especialidades);
        this.especialidades.removeIf(e->e.equals(especialidad));
    }


  public void mostrarIncidentes(){
        this.listaIncidentes.forEach(System.out::println);
  }



    public void mandarMensajeWhatApp(){

    }

    public void mostrarTecnicos(){


    }

    @Override
    public String toString() {
        return "Datos del tecnico\n" +
                "id=" + id + "\n" +
                "firstname=" + firstname + "\n" +
                "lastname=" + lastname + "\n" +
                "dni=" + dni + "\n" +
                "medio=" + medio + "\n" +
//               "listaIncidentes=" + listaIncidentes+ "\n" +
                "especialidades=" + especialidades + "\n" +
                "reporte_incidentes=" + reporte_incidentes;

    }
    //    public void mostrarIndicidentesAsignados(){
//        Objects.requireNonNull(this.problema,"No esta inicialiazado");
//        if(this.problema.size()>0 ){
//            this.problema.forEach(System.out::println);
//        }
//    }


}
