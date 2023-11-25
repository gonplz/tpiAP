package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameService;
    private LocalTime hours;

    public Servicio(String nameService, LocalTime hours) {
        this.nameService = nameService;
        this.hours = hours;
    }
}

