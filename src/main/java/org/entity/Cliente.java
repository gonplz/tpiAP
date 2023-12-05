package org.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="razonSocial")
    private String razonSocial;
    @Column(name="cuit")
    private String cuit;
    @Column(name = "correo")
    private String email;

    @OneToOne(mappedBy = "cliente",
            fetch = FetchType.EAGER,cascade = CascadeType.ALL,
            orphanRemoval = true) // cambiar a true
    Incidente incidente;

    @ElementCollection(targetClass = Especialidad.class) // indica que se mapea una Enum
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "Servicios", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "especialidad", columnDefinition = "VARCHAR(255)")
    private List<Especialidad> serviciosContratados = new ArrayList<>();

    public void setServicios(List<Especialidad>servicios){
        this.serviciosContratados=servicios;
    }

    public Cliente(String razonSocial, String cuit,String email) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.email=email;

    }


}
