package io.mk.sisadmin.resources;

import io.mk.sisadmin.domain.models.Pessoa;
import io.mk.sisadmin.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@ResponseBody
public class PessoaResource extends BaseResource{

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){
        List<Pessoa> pessoas = pessoaService.listar();

        if(pessoas == null)
            return new ResponseEntity<>(pessoas, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
        Pessoa pessoaBanco = pessoaService.salvar(pessoa);

        if(pessoaBanco == null)
            return new ResponseEntity<>(pessoaBanco, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(pessoaBanco, HttpStatus.OK);
    }
}
