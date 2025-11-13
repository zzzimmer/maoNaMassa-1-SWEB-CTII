package org.zzzimmer.maonamassa.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cores")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cor {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //não vai mapp porque não tem razão do banco/objeto cor saber do veículo
    //relação unidirecional
    private Long id;
    private String nome;
}
