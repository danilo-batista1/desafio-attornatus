package br.com.attornatus.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.desafio.model.EnderecoModel;
import br.com.attornatus.desafio.model.PessoaModel;
import br.com.attornatus.desafio.repository.EnderecoRepository;
import br.com.attornatus.desafio.repository.PessoaRepository;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    //Método para salvar pessoa
    @PostMapping(path = "/api/pessoa/salvar")
    public PessoaModel salvar(@RequestBody PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    //Método para consultar pessoa pelo ID
    @GetMapping(path = "/api/pessoa/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return pessoaRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    //Método para listar pessoas
    @GetMapping(path = "/api/pessoa/listar")
    public List<PessoaModel> listar() {
        return pessoaRepository.findAll();
    }
    
    //Método para atualizar dados da pessoa
    @PutMapping(path = "/api/pessoa/atualizar")
    public ResponseEntity atualizar(@RequestBody PessoaModel pessoa) {
        return pessoaRepository.findById(pessoa.getCodigo())
                .map(record -> {
                    record.setNome(pessoa.getNome());
                    record.setDataNascimento(pessoa.getDataNascimento());
                    PessoaModel updated = pessoaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    //Método para criar endereço para pessoa pelo ID
    @PostMapping(path = "/api/pessoa/{codigo}/endereco")
    public ResponseEntity criarEnderecosParaPessoa(@PathVariable("codigo") Integer codigo, @RequestBody List<EnderecoModel> enderecos) {
        return pessoaRepository.findById(codigo)
                .map(pessoa -> {
                	if (enderecos.stream().noneMatch(EnderecoModel::isPrincipal)) {
                        enderecos.get(0).setPrincipal(true);
                    }
                    pessoa.setEnderecos(enderecos);
                    pessoaRepository.save(pessoa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    //Método para listar endereços da pessoa pelo ID
    @GetMapping(path = "/api/pessoa/{codigo}/enderecos")
    public ResponseEntity listarEnderecosDaPessoa(@PathVariable("codigo") Integer codigo) {
        return pessoaRepository.findById(codigo)
                .map(pessoa -> ResponseEntity.ok().body(pessoa.getEnderecos()))
                .orElse(ResponseEntity.notFound().build());
    }
}
