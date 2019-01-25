package io.mk.sisadmin.repository;

import io.mk.sisadmin.model.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, Long> {
}
