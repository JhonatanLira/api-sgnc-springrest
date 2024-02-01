package br.com.sgnc.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "equipamento")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOnibus;
    @Column(name = "serial")
    private String serial;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "ano_fabricacao")
    private int anoFabricacao;
}
