package br.com.sgnc.domain.service;

import br.com.sgnc.domain.model.Setor;
import br.com.sgnc.domain.repository.SetorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    @Transactional
    public void saveSetor(Setor setor) {
        setorRepository.save(setor);
    }

    @Transactional
    public void deleteSetor(Long idSetor){

        setorRepository.deleteById(idSetor);
    }
}
