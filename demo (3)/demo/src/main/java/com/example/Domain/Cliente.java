package com.example.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Builder
// tabvelas de banco de dados
public class Cliente {
    @Id
//    no mysql temos o autoincremento(IDENTITY) mas no h2 temos que deixar AUTO
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    private String name;
    private String cpfCnpj;

    public Cliente() {
    }
}
