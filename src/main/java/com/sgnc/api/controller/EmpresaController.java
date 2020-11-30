package com.sgnc.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sgnc.domain.model.Empresa;
import com.sgnc.domain.repository.EmpresaRepository;
import com.sgnc.domain.service.CadastroEmpresaService;

@RestController
@RequestMapping("empresas")
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	CadastroEmpresaService empresaService;

	@GetMapping
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	@GetMapping("/{empresaId}")
	public ResponseEntity<Empresa> buscar(@PathVariable Long empresaId) {

		Optional<Empresa> empresa = empresaRepository.findById(empresaId);

		if (!empresa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empresa.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa adicionar(@Valid @RequestBody Empresa empresa) {

		return empresaService.salvarEmpresa(empresa);
	}

	@PutMapping("/{empresaId}")
	public ResponseEntity<Empresa> atualizar(@Valid @PathVariable Long empresaId, @RequestBody Empresa empresa) {

		if (!empresaRepository.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}
		empresa.setId(empresaId);
		empresa = empresaService.atualizarEmpresa(empresa);

		return ResponseEntity.ok(empresa);
	}

	@DeleteMapping("/{empresaId}")
	public ResponseEntity<Empresa> excluir(@PathVariable Long empresaId) {

		if (!empresaRepository.existsById(empresaId)) {
			return ResponseEntity.notFound().build();
		}

		empresaService.excluirEmpresa(empresaId);

		return ResponseEntity.noContent().build();
	}

}
