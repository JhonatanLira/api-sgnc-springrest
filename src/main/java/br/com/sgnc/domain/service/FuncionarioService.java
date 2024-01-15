package br.com.sgnc.domain.service;

import br.com.sgnc.domain.model.Funcionario;
import br.com.sgnc.domain.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Transactional
    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
}
