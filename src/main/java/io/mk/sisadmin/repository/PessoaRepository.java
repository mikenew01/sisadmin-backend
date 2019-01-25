package io.mk.sisadmin.repository;

import io.mk.sisadmin.model.entity.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, Long> {


    Pessoa findByNome(String nome);

}
