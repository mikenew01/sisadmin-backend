package io.mk.aprender.repository;

import io.mk.aprender.model.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, Long> {

    Perfil findByNome(String nome);

}
