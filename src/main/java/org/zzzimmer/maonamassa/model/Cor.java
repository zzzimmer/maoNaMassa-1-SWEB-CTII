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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
