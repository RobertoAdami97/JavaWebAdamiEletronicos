package br.edu.usj.eletroeletronicos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Eletronicos {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nome;
    String descricao;
    Float preco;
    Integer codigo;
    Integer quantidade;

   
}