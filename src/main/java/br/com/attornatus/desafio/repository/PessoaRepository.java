package br.com.attornatus.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.attornatus.desafio.model.PessoaModel;

public interface PessoaRepository extends CrudRepository<PessoaModel, Integer> {
	
    List<PessoaModel> findAll();

}
