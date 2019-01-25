package io.mk.sisadmin.resources;

import io.mk.sisadmin.model.entity.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseResource {

    public Usuario getUsuarioLogado(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            return (Usuario) authentication.getPrincipal();
        }catch (Exception e){
            throw e;
        }
    }
}
