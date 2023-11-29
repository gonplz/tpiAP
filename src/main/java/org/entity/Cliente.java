package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<Incidente> incidentes = new HashSet<>();

    public Cliente(String razonSocial, String cuit, Set<Incidente> incidentes) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.incidentes = incidentes;
    }

}
