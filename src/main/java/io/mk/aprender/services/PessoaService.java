package io.mk.aprender.services;

import io.mk.aprender.repository.PessoaRepository;
import io.mk.aprender.model.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PessoaService implements Serializable{

    private final PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService(final PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
