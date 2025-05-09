package com.example.lab4_gtics_20251_20211602.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "tower")
public class Tower {

    // Se esta usando jakarta y no javax porque mi máquina no reconoce javax por alguna razon, intente
    // tod o lo posible pero no logre usar javax

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 5, max = 100, message = "Debe tener entre 5 y 100 caracteres")
    private String name;

    @NotBlank(message = "La ubicación no puede estar vacía")
    @Size(min = 5, message = "Debe tener al menos 5 caracteres")
    private String location;

    @NotNull(message = "La altura es obligatoria")
    @Min(value = 10, message = "La altura mínima es 10 metros")
    @Max(value = 300, message = "La altura máxima es 300 metros")
    private Double height;

    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(name = "installation_date")
    private Date installationDate;  // ← usa java.sql.Date, no java.time.LocalDate

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    @NotNull(message = "Debe seleccionar un estado")
    private TowerState state;

}
