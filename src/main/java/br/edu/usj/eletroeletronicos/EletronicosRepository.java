package br.edu.usj.eletroeletronicos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EletronicosRepository extends CrudRepository<Eletronicos, Long> {
    List<Eletronicos> findAll();
}