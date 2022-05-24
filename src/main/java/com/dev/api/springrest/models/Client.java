package com.dev.api.springrest.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cli_id")
    private Long id;
    @Column(name= "cli_name")
    private String name;
    @Column(name= "cli_user")
    private String userName;
    @Column(name= "cli_email")
    private String email;
    @Column(name= "cli_cpf", unique = true)
    private String cpf;
    @Column(name= "cli_birth")
    private String birthDate;
    @Column(name= "cli_address")
    private String address;
    @Column(name= "cli_tel")
    private String telephone;

    @ManyToMany
    @JoinTable(name="client_prod", joinColumns = {@JoinColumn(name="prod_id")}, inverseJoinColumns = {@JoinColumn(name="cli_id")})
    private List<Product> products;

    public Client() {}

    public Client(Long id, String name, String userName, String email, String cpf, String birthDate, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
        this.telephone = telephone;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
