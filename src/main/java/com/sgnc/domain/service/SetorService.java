package com.sgnc.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgnc.domain.model.Setor;
import com.sgnc.domain.repository.SetorRepository;

@Service
public class SetorService {

	@Autowired
	SetorRepository setorRepository;

	public Setor save(Setor setor) {
		return setorRepository.save(setor);
	}

	public Setor update(Setor setor) {

		return setorRepository.save(setor);
	}

	public void delete(Long idSetor) {
		setorRepository.deleteById(idSetor);
	}

	public Setor findById(Long idSetor) {
		return setorRepository.findById(idSetor).get();
	}

	public List<Setor> findAll() {
		return setorRepository.findAll();
	}
}
