package br.edu.usj.eletroeletronicos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {
    List<Clientes> findAll();
}