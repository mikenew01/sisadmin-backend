package io.mk.aprender.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "pessoas")
public class Pessoa implements Serializable {

    @Id
    private String id;

    private String nome;

    private String sobreNome;

    private Date dataNascimento;
}
