package com.example.apismsgibackend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

            private Long id;
            private String nome;
            private String cpfCnpj;


}
