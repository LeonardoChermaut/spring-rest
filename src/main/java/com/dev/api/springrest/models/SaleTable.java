package com.dev.api.springrest.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class SaleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private long id;
    @Column(name = "sale_date")
    private Date date;
    @Column(name = "sale_quantity")
    private int quantity;
    @Column(name = "sale_value")
    private double value;


    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<RelProductSale> productSales;


    public SaleTable(long id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;

    }
}
