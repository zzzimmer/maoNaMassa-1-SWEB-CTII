package org.zzzimmer.maonamassa.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    // Many veiculos has One proprietario. A perspectiva da frase é a do banco de dados
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente proprietario;

    public Veiculo(Long id, String placa, String observacoes, Modelo modelo, Cor cor, Cliente proprietario) {
        this.id = id;
        this.placa = placa;
        this.observacoes = observacoes;
        this.modelo = modelo;
        this.cor = cor;
        this.proprietario = proprietario;
    }

    public Veiculo(Veiculo veiculo) {
        this.id = veiculo.id;
        this.placa = veiculo.placa;
        this.observacoes = veiculo.observacoes;
        this.modelo = veiculo.modelo;
        this.cor = veiculo.cor;
        this.proprietario = veiculo.proprietario;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placa);
    }
}
