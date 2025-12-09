package org.zzzimmer.maonamassa.dto;

import org.zzzimmer.maonamassa.model.ETipoDeCombustivel;
import org.zzzimmer.maonamassa.model.Ecategoria;

public record ResponseModeloDTO(Long id,
                                String descricao,
                                String marcaName,
                                Ecategoria eCategoria,
                                Integer motorPotencia,
                                ETipoDeCombustivel motorETipoDeCombustivel
                                ) {
}
