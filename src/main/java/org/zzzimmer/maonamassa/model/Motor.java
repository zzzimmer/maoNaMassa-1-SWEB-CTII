package org.zzzimmer.maonamassa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "motores")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Motor {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe a potência do motor")
    @Positive
    private Integer potencia;

    @NotNull(message = "Informe o tipo de combustivel do motor")
    @Enumerated(EnumType.STRING)
    private ETipoDeCombustivel eTipoCombustivel;

//    @NotNull(message = "Informe o modelo")
//    @Getter //aqui, garante que sera implementado apenas o Getter de modelo.
//    // Visto a composição, não é adequado ter um seter de modelo
    @OneToOne
    @JoinColumn
    @MapsId
    private Modelo modelo;
}
