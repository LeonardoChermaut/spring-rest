package com.dev.api.springrest.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data()
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="client")
    private Set<Address> address;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column( nullable = false)
    private String email;

    @Column( unique = true, nullable = false)
    private String cpf;

    private Date birthDate;

    @Column( nullable = false)
    private String telephone;


    public Client() {
    }

    public Client(Long id, String name, String userName, String email, String cpf, Date birthDate, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.telephone = telephone;
    }

}
