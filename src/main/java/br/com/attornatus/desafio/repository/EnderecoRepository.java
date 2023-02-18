package br.com.attornatus.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.desafio.model.PessoaModel;

@Repository
public interface EnderecoRepository extends CrudRepository<PessoaModel, Integer> {
	
}
