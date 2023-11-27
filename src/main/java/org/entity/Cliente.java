package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.repository.CrudRepositorie;

import javax.persistence.*;
import java.util.Set;

@Data
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

    @OneToMany(mappedBy = "cliente")
    private Set<Incidente> incidentes;

    public Cliente(String razonSocial, String cuit, Set<Incidente> incidentes) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.incidentes = incidentes;
    }

}
