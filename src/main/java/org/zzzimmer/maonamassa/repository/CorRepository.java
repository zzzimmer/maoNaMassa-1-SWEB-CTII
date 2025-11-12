package org.zzzimmer.maonamassa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zzzimmer.maonamassa.model.Cor;

import java.util.Optional;

public interface CorRepository extends JpaRepository<Cor, Long> {

    Optional<Cor> findByNome(String nome);
}
