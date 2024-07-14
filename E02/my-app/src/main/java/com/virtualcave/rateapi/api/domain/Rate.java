package com.virtualcave.rateapi.api.domain;

import java.time.LocalDate;

public class Rate {
    private Long id;
    private Long brandId;
    private Long productId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String currencyCode;

    // Constructor, Getters y Setters

    public Rate() {}

    public Rate(Long id, Long brandId, Long productId, LocalDate startDate, LocalDate endDate, Double price, String currencyCode) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}

/*es una clase que representa el objeto de dominio de una tarifa. Este archivo define la estructura de una tarifa en tu aplicación, separada de cómo se almacena en la base de datos.*/