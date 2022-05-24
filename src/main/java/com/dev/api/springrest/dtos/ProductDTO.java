package com.dev.api.springrest.dtos;

import com.dev.api.springrest.models.Category;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductDTO {

    private Long id;
    private String name;
    private Double unitaryValue;
    private String description;
    private String expirationDate;
    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double unitaryValue, String description, String expirationDate, int quantity) {
        this.id = id;
        this.name = name;
        this.unitaryValue = unitaryValue;
        this.description = description;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
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

    public Double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(Double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
