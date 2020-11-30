package com.sgnc.api.controller;

import java.util.List;

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

import com.sgnc.domain.model.Setor;
import com.sgnc.domain.repository.SetorRepository;
import com.sgnc.domain.service.SetorService;

@RestController
@RequestMapping("setores")
public class SetorController {

	@Autowired
	SetorService setorService;

	@Autowired
	SetorRepository setorRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Setor inserir(@Valid @RequestBody Setor setor) {

		return setorService.save(setor);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Setor> alterar(@Valid @PathVariable Long setorId, @RequestBody Setor setor) {

		if (!setorRepository.existsById(setorId)) {
			return ResponseEntity.notFound().build();
		}
		setor.setIdSetor(setorId);
		setor = setorService.save(setor);
		return ResponseEntity.ok(setor);
	}

	@DeleteMapping("/{setorId}")
	public ResponseEntity<Setor> excluir(Long setorId) {

		if (!setorRepository.existsById(setorId)) {
			return ResponseEntity.notFound().build();
		}

		setorService.delete(setorId);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{setorId}")
	@ResponseStatus(HttpStatus.OK)
	public Setor buscarPorId(Long id) {
		return setorRepository.findById(id).get();
	}

	@GetMapping
	public List<Setor> listar() {
		return setorService.findAll();
	}

}
