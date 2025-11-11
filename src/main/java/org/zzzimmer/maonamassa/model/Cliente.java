package org.zzzimmer.maonamassa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String celular;
    private String email;
    private LocalDate dataCadastro;

    //One proprietario has Many Veiculos. A perspectiva da frase é a do banco de dados
    //Nesse caso, um veiculo não pode ter mais de um proprietario
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.REMOVE)
    private List<Veiculo> veiculos;

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(celular, cliente.celular) && Objects.equals(email, cliente.email) && Objects.equals(dataCadastro, cliente.dataCadastro) && Objects.equals(veiculos, cliente.veiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, celular, email, dataCadastro, veiculos);
    }
}
