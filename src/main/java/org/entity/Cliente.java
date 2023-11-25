package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.repository.CrudRepositorie;

import javax.persistence.*;

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

    public Cliente(String razonSocial, String cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

}
