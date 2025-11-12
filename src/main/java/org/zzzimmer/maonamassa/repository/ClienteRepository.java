package org.zzzimmer.maonamassa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zzzimmer.maonamassa.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
