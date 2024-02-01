package br.com.sgnc.web.controller;

import br.com.sgnc.domain.model.Setor;
import br.com.sgnc.domain.repository.SetorRepository;
import br.com.sgnc.domain.service.SetorService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "SETOR", description = "CRUD dos setores da empresa proprietária do veículos")
@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private SetorService setorService;

    @GetMapping
    public List<Setor> listarSetor() {
        return setorRepository.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Setor> buscaSetorPorId(@PathVariable Long idEmpresa) {
        if (idEmpresa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(setorRepository.findById(idEmpresa).get());

    }

    @PostMapping
    public ResponseEntity<Setor> adicionarSetor(@RequestBody @Valid Setor setor) {
        if (setor != null) {
            setorService.saveSetor(setor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idSetor}")
    public ResponseEntity<Setor> atualizarSetor(@PathVariable Long idSetor, @RequestBody @Valid Setor setorAtualizado) {

        if (setorRepository.findById(idSetor).isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Setor setor = setorRepository.findById(idSetor).get();
        BeanUtils.copyProperties(setorAtualizado, setor, "idSetor");
        setorService.saveSetor(setor);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{idSetor}")
    public ResponseEntity<Setor> apagarSetor(@PathVariable Long idSetor) {
        if (setorRepository.findById(idSetor).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        setorService.deleteSetor(idSetor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
