package org.zzzimmer.maonamassa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "veiculos")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Necessário adicionar placa")
    @Size( min = 8, max = 8, message = "A placa deve ter exatamente 8 caracteres")
    private String placa;

    @Size(max = 200,message = "No máximo 200 caracteres")
    private String observacoes;

    @NotNull(message = "Adicione modelo")
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @NotNull(message = "Informe uma cor")
    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    // Many veiculos has One proprietario. A perspectiva da frase é a do banco de dados
    //Define que o atributo não pode ser nulo, neste caso, aplicado para variáveis numéricas e
    // tipo class que não seja a String (por exemplo: preco, categoria e fornecedor).
    @NotNull(message = "Informe o dono do veículo")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente proprietario;
}
