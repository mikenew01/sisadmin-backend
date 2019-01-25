package io.mk.aprender.repository;

import io.mk.aprender.model.entity.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, Long> {


    Pessoa findByNome(String nome);

}
