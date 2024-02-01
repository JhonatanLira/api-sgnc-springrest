package br.com.sgnc.domain.service;

import br.com.sgnc.domain.model.Funcionario;
import br.com.sgnc.domain.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void updateFuncionario(Long idFuncionario, Funcionario funcionarioAlterado) {

        System.out.println("ID Service: "+ idFuncionario+"\n Funcionario Alterado Service : "+funcionarioAlterado);

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();
        System.out.println("Funcionario Buscado : "+ funcionario);
        BeanUtils.copyProperties(funcionarioAlterado, funcionario, "idFuncionario");
        System.out.println("Funcionario enviado : "+ funcionario);
        saveFuncionario(funcionario);
    }
}
