package org.zzzimmer.maonamassa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zzzimmer.maonamassa.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
//    Veiculo findById(Long id);
}
