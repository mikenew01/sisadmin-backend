package io.mk.sisadmin.repository;

import io.mk.sisadmin.model.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
