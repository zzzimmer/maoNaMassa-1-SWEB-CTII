package org.zzzimmer.maonamassa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

//    @JsonIgnore //garante que o Json não vai serializar o modelo e criar recursão infinita
    @OneToOne
    @JoinColumn
    private Modelo modelo;

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModelo() {
        return modelo;
    }
}
