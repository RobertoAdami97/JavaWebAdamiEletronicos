package br.edu.usj.eletroeletronicos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
    List<Contato> findAll();
}