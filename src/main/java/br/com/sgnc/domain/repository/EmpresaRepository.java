package br.com.sgnc.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sgnc.domain.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String>{
	
	Optional<Empresa> findByCnpj(String cnpj);

	void deleteByCnpj(String cnpj);

}
