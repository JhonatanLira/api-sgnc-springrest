package com.sgnc.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgnc.domain.model.Empresa;
import com.sgnc.domain.repository.EmpresaRepository;

@Service
public class CadastroEmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa salvarEmpresa(Empresa empresa) {
		
		String cnpjLimpo = empresa.getCnpj().replace(".", "").replace("-", "").replace("/", "");
		
		empresa.setCnpj(cnpjLimpo);
		
		return empresaRepository.save(empresa);
	}

	public Empresa atualizarEmpresa(Empresa empresa) {

		return empresaRepository.save(empresa);
	}

	public void excluirEmpresa(Long empresaId) {

		empresaRepository.deleteById(empresaId);
	}
}
