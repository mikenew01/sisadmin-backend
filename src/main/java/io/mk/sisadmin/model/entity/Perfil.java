package io.mk.sisadmin.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "perfis")
public class Perfil implements GrantedAuthority {

    @Id
    private String id;

    private String nome;

    private String descricao;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getNome();
    }
}
