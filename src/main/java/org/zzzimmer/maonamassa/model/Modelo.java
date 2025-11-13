package org.zzzimmer.maonamassa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modelos")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Modelo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    private Marca marca;

    @Enumerated(EnumType.STRING)
    private Ecategoria ecategoria;
    @OneToOne (mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("modelo")
    @Getter //somente um getter, afinal já é setado via composição
    private Motor motor;

    public Modelo() {//atentar para diferença de construtor sem argumentos para construtor vazio
        this.motor = new Motor();
        motor.setModelo(this);

    }
}
