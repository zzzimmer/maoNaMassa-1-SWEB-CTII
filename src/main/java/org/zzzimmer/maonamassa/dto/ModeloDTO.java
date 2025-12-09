package org.zzzimmer.maonamassa.dto;

import org.zzzimmer.maonamassa.model.ETipoDeCombustivel;
import org.zzzimmer.maonamassa.model.Ecategoria;

public record ModeloDTO(String descricao,
                        Long marcaId,
                        Ecategoria eCategoria,
                        Integer potencia,
                        ETipoDeCombustivel eTipoCombustivel) {
}
