package io.mk.sisadmin.services;

import io.mk.sisadmin.model.entity.Perfil;
import io.mk.sisadmin.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PerfilService implements Serializable {


    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilService(final PerfilRepository perfilRepository){
        this.perfilRepository = perfilRepository;
    }

    public List<Perfil> delete(final Long id){
        this.perfilRepository.delete(perfilRepository.findById(id).get());
        return this.findAll();
    }

    public List<Perfil> findAll(){
        return perfilRepository.findAll();
    }

    public List<Perfil> save(Perfil perfil){
        perfilRepository.save(perfil);
        return findAll();
    }

    public List<Perfil> update(Perfil perfil){
        perfilRepository.save(perfil);
        return this.findAll();
    }

}
