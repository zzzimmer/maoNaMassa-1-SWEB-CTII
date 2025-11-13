package org.zzzimmer.maonamassa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private int potencia;
    @Enumerated(EnumType.STRING)
    private ETipoDeCombustivel eTipoCombustivel;

    @Getter //aqui, garante que sera implementado apenas o Getter de modelo.
    // Visto a composição, não é adequado ter um seter de modelo
    @OneToOne
    @JoinColumn
    private Modelo modelo;
}
