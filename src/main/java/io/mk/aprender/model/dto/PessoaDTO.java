package io.mk.aprender.model.dto;


import io.mk.aprender.configuration.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO  extends BaseDTO {

    private String nome;
    private String sobreNome;

}
