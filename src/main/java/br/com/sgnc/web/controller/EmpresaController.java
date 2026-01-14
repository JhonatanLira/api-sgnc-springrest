package br.com.sgnc.web.controller;


import java.util.List;


//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.sgnc.domain.model.Empresa;
import br.com.sgnc.domain.repository.EmpresaRepository;
import br.com.sgnc.domain.service.EmpresaService;
//@Tag(name = "EMPRESA", description = "CRUD da empresa proprietária do veículos")
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

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long idEmpresa) {

        if (empresaRepository.findById(idEmpresa).isPresent()) {
            return ResponseEntity.ok(empresaRepository.findById(idEmpresa).get());
        }
        return ResponseEntity.notFound().build();
    }
    //Busca por CNPJ

    @PostMapping
    public ResponseEntity<Empresa> adicionarEmpresa(@RequestBody @Valid Empresa empresa) {

        if (empresa != null) {
            empresaService.empresaSave(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long idEmpresa, @RequestBody Empresa empresaAtualizada) {

        if (empresaRepository.findById(idEmpresa).isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Empresa empresa = empresaRepository.findById(idEmpresa).get();
        BeanUtils.copyProperties(empresaAtualizada, empresa, "idEmpresa");

        empresaService.empresaSave(empresa);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

	@DeleteMapping("/{idEmpresa}")
	public ResponseEntity<Empresa> deletarEmpesaPorId(@PathVariable Long idEmpresa){

		if (empresaRepository.findById(idEmpresa).isEmpty()){
			return ResponseEntity.noContent().build();
		}
        empresaService.empresaDeleteById(idEmpresa);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
//http://localhost:8080/swagger-ui.html
//https://medium.com/@f.s.a.kuzman/using-swagger-3-in-spring-boot-3-c11a483ea6dc
//https://www.schoolofnet.com/curso/nodejs/outros-frameworks-nodejs/swagger-e-jsdocs/