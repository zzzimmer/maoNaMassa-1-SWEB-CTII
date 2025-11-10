package org.zzzimmer.maonamassa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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
}
