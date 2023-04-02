package br.com.sgnc.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgnc.domain.model.Empresa;
import br.com.sgnc.domain.repository.EmpresaRepository;
import br.com.sgnc.domain.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	EmpresaService empresaService;

	@GetMapping
	public List<Empresa> listar() {

		return empresaRepository.findAll();

	}

	@PostMapping
	public ResponseEntity<Empresa> salvar(@Valid @RequestBody Empresa empresa) {

		//empresaRepository.save(empresa);
		empresaService.adicionar(empresa);

		return ResponseEntity.created(null).build();
	}

	@GetMapping("/{cnpj}")
	public ResponseEntity<Empresa> buscarPorCnpj(@PathVariable String cnpj) {

		Optional<Empresa> empresaOptional = empresaRepository.findByCnpj(cnpj);

		if (empresaOptional.isPresent()) {

			return ResponseEntity.ok(empresaOptional.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{cnpj}")
	public ResponseEntity<Empresa> atulializar(@Valid @PathVariable String cnpj, @RequestBody Empresa empresa) {

		if (!empresaRepository.existsById(cnpj)) {
			return ResponseEntity.notFound().build();
		}

		empresa.setCnpj(cnpj);
		//empresaRepository.save(empresa);
		empresaService.adicionar(empresa);

		return ResponseEntity.ok(empresa);
	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Void> deletar(@PathVariable String cnpj) {

		if (empresaRepository.existsById(cnpj)) {
			empresaService.remover(cnpj);
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

}
