package br.com.sgnc.domain.repository;

import br.com.sgnc.domain.model.Equipamento;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
