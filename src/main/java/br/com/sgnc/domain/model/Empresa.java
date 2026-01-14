package br.com.sgnc.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	@Size(min = 14, max = 20)
	@Column(name = "cnpj", unique = true, nullable = false)
	private String cnpj;
	@Column(name = "razao_social")
	private String razaoSocial;
	@Column(name = "nome_fantasia")
	private String nomeFantasia;

}