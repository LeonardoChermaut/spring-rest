package com.dev.api.springrest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(name="desc", nullable = false)
    private String description;
    @Column( nullable = false)
    private Date expirationDate;
    @Column( nullable = false)
    private int quantity;

    //RELATIONSHIP CATEGORY
    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private Category category;

    //RELATIONSHIP PRODUCT to SALE
    @OneToMany(mappedBy = "product")
    private Set<RelProductSale> productSales;

    //RELATIONSHIP EMPLOYEE
    @ManyToOne
    private Employee employee;

    public Product(Long id, String name, Double price, String description, Date expirationDate, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }
}
