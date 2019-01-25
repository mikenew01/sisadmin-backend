package io.mk.aprender.model.entity;

import io.mk.aprender.configuration.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "pessoas")
public class Pessoa extends BaseEntity {

    @Id
    private String id;

    private String nome;

    private String sobreNome;

    private Date dataNascimento;
}
