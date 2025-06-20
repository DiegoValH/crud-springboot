package com.diegovalencia.crudsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
public abstract class Person {

    private String nome;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Address> enderecos;
}
