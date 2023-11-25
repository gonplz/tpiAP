package org.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table(name= "problema")
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipoName;
    private LocalTime timeMAX;
    private LocalTime timeFinal;

    public TipoProblema(String tipoName, LocalTime timeMAX, LocalTime timeFinal) {
        this.tipoName = tipoName;
        this.timeMAX = timeMAX;
        this.timeFinal = timeFinal;
    }
}
