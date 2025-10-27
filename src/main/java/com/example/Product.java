package com.example;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Product {

    private final UUID id;
    private final String name;
    private final Category category;
    private BigDecimal price;

    public Product(UUID id, String name, Category category, BigDecimal price) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be null or blank");
        if (category == null) throw new IllegalArgumentException("category cannot be null");
        if (price == null) throw new IllegalArgumentException("price cannot be null");
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public UUID uuid() {
        return id;
    }


    public UUID getId() {
        return id;
    }

    public String name() {
        return name;
    }

    public Category category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }


    public void price(BigDecimal newPrice) {
        if (newPrice == null) throw new IllegalArgumentException("Price cannot be null.");
        this.price = newPrice;
    }


    public abstract String productDetails();
}