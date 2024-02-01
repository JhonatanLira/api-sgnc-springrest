package br.com.sgnc.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "setor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetor;

    @Column(name = "nome_setor", nullable = false)
    @Size(min = 2)
    private String nomeSetor;
    @ManyToOne
    @JoinColumn(name = "fk_empresa")
    private Empresa empesa;
}
