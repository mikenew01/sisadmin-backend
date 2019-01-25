package io.mk.aprender.configuration.database;

import io.mk.aprender.model.entity.Perfil;
import io.mk.aprender.model.entity.Pessoa;
import io.mk.aprender.model.entity.Usuario;
import io.mk.aprender.repository.PerfilRepository;
import io.mk.aprender.repository.PessoaRepository;
import io.mk.aprender.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class InitialDatabaseService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void initial(){

        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(new Date());
        pessoa.setNome("Maikon");
        pessoa.setSobreNome("Canuto");

        Perfil perfil = new Perfil("ROLE_ADMIN", "Administrador do sistema");

        Pessoa pessoaBanco = pessoaRepository.findByNome(pessoa.getNome());
        Perfil perfilBanco = perfilRepository.findByNome(perfil.getNome());
        Usuario usuarioBanco = usuarioRepository.findByUsername("maikoncanuto");


        if(pessoaBanco == null)
            pessoa = pessoaRepository.save(pessoa);
        else
            pessoa = pessoaBanco;


        if(perfilBanco == null)
            perfil = perfilRepository.save(perfil);
        else
            perfil = perfilBanco;

        List<Perfil> perfis = Arrays.asList(perfil);

        Usuario usuario = new Usuario();
        usuario.setPassword("$2a$10$2WKGnhqRQEuYPocwGMTvg.77wHIWmMlAZW.4ds8dfDUKYJmX11ey6");
        usuario.setPessoa(pessoa);
        usuario.setUsername("maikoncanuto");
        usuario.setPerfis(perfis);


        if(usuarioBanco == null)
            usuario = usuarioRepository.save(usuario);
        else
            usuario = usuarioBanco;

    }

}
