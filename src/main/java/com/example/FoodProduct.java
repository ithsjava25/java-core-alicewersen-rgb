package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product implements Perishable, Shippable {

    private final LocalDate expirationDate;
    private final BigDecimal weight;

    public FoodProduct(UUID id, String name, Category category, BigDecimal price,
                       LocalDate expirationDate, BigDecimal weight) {


        super(id, name, category, validatePrice(price));

        if (weight == null) {
            throw new IllegalArgumentException("Weight cannot be null.");
        }
        if (weight.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }

        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    private static BigDecimal validatePrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null.");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        return price;
    }

    @Override
    public LocalDate expirationDate() {
        return expirationDate;
    }

    @Override
    public BigDecimal calculateShippingCost() {

        return weight.multiply(BigDecimal.valueOf(50))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public double weight() {
        return weight.doubleValue();
    }

    @Override
    public String productDetails() {
        return String.format("Food: %s, Expires: %s", name(), expirationDate);
    }
}
