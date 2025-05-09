package com.example.lab4_gtics_20251_20211602.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{9}", message = "Debe tener 9 dígitos")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Debe tener 11 dígitos")
    private String ruc;

    @NotEmpty(message = "Debe seleccionar al menos un tipo de equipamiento")
    @ManyToMany
    @JoinTable(
            name = "provider_equipment_type",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_type_id")
    )
    private List<EquipmentType> equipmentTypes;
}
