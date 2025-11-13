package org.zzzimmer.maonamassa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "clientes")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@EqualsAndHashCode(of = "id")
@ToString
public class Cliente {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe um nome para o cliente")
    @Size(max=80, message = "O nome não pode exceder 80 caracteres")
    private String nome;

    @NotBlank(message = "Obrigatório informar telefone")
    @Size(max = 20, message = "Até 20 caracteres")
    private String celular;

    @NotBlank(message = "Informe o e-mail")
    @Size(max = 50, message = "Email com até 50 caracteres")
    private String email;

    private LocalDate dataCadastro = LocalDate.now();

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Veiculo> veiculos = new ArrayList<>();

    public void addVeiculo (Veiculo veiculo){
        this.veiculos.add(veiculo);
        veiculo.setProprietario(this);
    }

    public void removeVeiculo(Veiculo veiculo){
        this.veiculos.remove(veiculo);
        veiculo.setProprietario(null);
    }

}
