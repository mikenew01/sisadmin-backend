package io.mk.sisadmin.domain.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PerfilDTO implements Serializable {

    private String nome;
    private String descricao;


}
