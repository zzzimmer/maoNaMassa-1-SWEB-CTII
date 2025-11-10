package org.zzzimmer.maonamassa.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cores")
public class Cor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //não vai mapp porque não tem razão do banco/objeto cor saber do veículo
    //relação unidirecional
    private Long id;
    private String nome;
}
