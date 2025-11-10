package org.zzzimmer.maonamassa.model;

import jakarta.persistence.*;


@Entity
@Table(name = "motores")
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int potencia;
    @Enumerated(EnumType.STRING)
    private ETipoDeCombustivel eTipoCombustivel;
}
