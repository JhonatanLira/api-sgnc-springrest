package br.com.sgnc.domain.service;

import java.text.ParseException;
import java.util.List;

import javax.swing.text.MaskFormatter;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgnc.domain.model.Empresa;
import br.com.sgnc.domain.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Transactional
	public Empresa adicionar(Empresa empresa) {
		
		String cnpj = empresa.getCnpj();
		empresa.setCnpj(cnpj.replace(".", "").replace("/", "").replace("-", ""));
		
		return empresaRepository.save(empresa);
	}
	
	@Transactional
	public void remover(String cnpj) {
		
		empresaRepository.deleteByCnpj(cnpj);
	}
	
}//fim service