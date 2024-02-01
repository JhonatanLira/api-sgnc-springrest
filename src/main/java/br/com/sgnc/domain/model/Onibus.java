package br.com.sgnc.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "onibus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Onibus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOnibus;
    @Column(name = "numero")
    private String numero;
    @Column(name = "placa")
    private String placa;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "ano")
    private int ano;
    @Column(name = "chassi")
    private String chassi;
}
