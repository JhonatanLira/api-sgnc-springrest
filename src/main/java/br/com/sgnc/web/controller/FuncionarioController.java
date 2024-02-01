package br.com.sgnc.web.controller;

import br.com.sgnc.domain.model.Funcionario;
import br.com.sgnc.domain.model.Setor;
import br.com.sgnc.domain.repository.FuncionarioRepository;
import br.com.sgnc.domain.service.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "FUNCIONARIO", description = "CRUD dos funcionarios da empresa proprietária do veículos")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionacios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Funcionario> adicionarFuncionario(@RequestBody @Valid Funcionario funcionario) {

        funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idFuncionario}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long idFuncionario) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(idFuncionario);
        if (funcionarioOptional.isPresent()) {
            return ResponseEntity.ok(funcionarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{idFuncionario}")
    public ResponseEntity<Funcionario> atualizaFuncionario(@PathVariable Long idFuncionario, Funcionario funcionarioAlterado) {


        if (funcionarioRepository.findById(idFuncionario).isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();
        BeanUtils.copyProperties(funcionarioAlterado, funcionario, "idFuncionario");
        funcionarioService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
