package io.mk.aprender.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mk.aprender.configuration.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "perfis")
public class Perfil extends BaseEntity implements GrantedAuthority {

    @Id
    private String id;

    private String nome;

    private String descricao;

    public Perfil(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getNome();
    }
}
