package br.com.sgnc.domain.service;

import br.com.sgnc.domain.model.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgnc.domain.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Transactional
    public Empresa empresaSave(Empresa empresa) {

        String cnpj = empresa.getCnpj();
        empresa.setCnpj(cnpj.replace(".", "").replace("/", "").replace("-", ""));

        return empresaRepository.save(empresa);
    }
    @Transactional
    public void empresaDeleteById(Long idEmpresa) {

        empresaRepository.deleteById(idEmpresa);
    }
}//fim service