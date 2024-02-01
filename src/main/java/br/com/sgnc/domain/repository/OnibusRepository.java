package br.com.sgnc.domain.repository;

import br.com.sgnc.domain.model.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnibusRepository extends JpaRepository<Onibus,Long> {
}
