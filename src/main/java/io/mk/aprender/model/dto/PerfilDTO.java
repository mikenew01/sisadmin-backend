package io.mk.aprender.model.dto;

import io.mk.aprender.configuration.base.BaseDTO;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PerfilDTO extends BaseDTO {

    private String id;
    private String nome;
    private String descricao;

}
