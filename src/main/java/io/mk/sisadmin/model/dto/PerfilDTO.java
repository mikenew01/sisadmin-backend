package io.mk.sisadmin.model.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class PerfilDTO implements Serializable {

    private String nome;
    private String descricao;


}
