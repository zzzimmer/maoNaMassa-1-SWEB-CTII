package org.zzzimmer.maonamassa.dto;

public record ResponseVeiculoDTO(Long id,
                                 String placa,
                                 String observacoes,
                                 Long modelo_id,
                                 Long cor_id,
                                 Long proprietario_id) {
}
