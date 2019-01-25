package io.mk.aprender.resources;

import io.mk.aprender.configuration.base.BaseResource;
import io.mk.aprender.model.entity.Perfil;
import io.mk.aprender.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@ResponseBody
public class PerfilResource extends BaseResource {

    @Autowired
    private PerfilService perfilService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        perfilService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> findAll(){
        List<Perfil> perfis = perfilService.findAll();

        if(perfis == null)
            return new ResponseEntity<>(perfis, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(perfis, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Perfil>> save(@RequestBody Perfil perfil){
        List<Perfil> perfis = perfilService.save(perfil);

        if(perfis == null)
            return new ResponseEntity<>(perfis, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(perfis, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<List<Perfil>> update(@RequestBody Perfil perfil){
        List<Perfil> perfis = perfilService.update(perfil);

        if(perfis == null)
            return new ResponseEntity<>(perfis, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(perfis, HttpStatus.CREATED);
    }
}
