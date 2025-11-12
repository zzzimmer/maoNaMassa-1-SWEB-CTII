package org.zzzimmer.maonamassa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
//   @JoinColumn(name = "marca_id")//
    //nesse caso acima não precisa. Essa é a implementação padrão do banco pela JPA {nomeEntidade}_id
    // caso fosse diferente NO BANCO, como id_{nomeEntidade}, ai seria necessário usar a notação
    //    @JoinColumn(name = "id_marca")// Ou qualquer outro nome no banco que represente esse atributo
    private Marca marca;

    @Enumerated(EnumType.STRING)
    private Ecategoria ecategoria;
    @OneToOne (mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("modelo")
    private Motor motor;

    public Modelo() {
        this.motor = new Motor();
        motor.setModelo(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Ecategoria getEcategoria() {
        return ecategoria;
    }

    public void setEcategoria(Ecategoria ecategoria) {
        this.ecategoria = ecategoria;
    }

    public Motor getMotor() {
        return motor;
    }
}
