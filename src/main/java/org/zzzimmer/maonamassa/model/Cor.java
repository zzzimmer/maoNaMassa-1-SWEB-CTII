package org.zzzimmer.maonamassa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Informe o nome da cor")
    @Size(max = 20, message = "Máximo 20 caracteres")
    private String nome;
}
