package br.com.sgnc.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String password;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "nivel")
    private int nivel;

}
