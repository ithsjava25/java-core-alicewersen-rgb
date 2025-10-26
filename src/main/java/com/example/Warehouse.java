package com.example;

import java.util.*;

public class Warehouse {
    private static final Map<String, Warehouse> INSTANCES = new HashMap<>();
    private final String name;
    private final List<Product> products = new ArrayList<>();
    private final List<Product> changedProducts = new ArrayList<>();

    private Warehouse(String name) {
        this.name = name;
    }


    public static Warehouse getInstance(String name) {
        return INSTANCES.computeIfAbsent(name, Warehouse::new);
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> getProductById(UUID id) {
        return products.stream().filter(p -> p.uuid().equals(id)).findFirst();
    }

    public void updateProductPrice(UUID id, java.math.BigDecimal newPrice) {
        Product product = getProductById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
        product.price(newPrice);
        changedProducts.add(product);
    }

    public List<Product> getChangedProducts() {
        return Collections.unmodifiableList(changedProducts);
    }

    public List<Product> expiredProducts() {
        List<Product> expired = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Perishable && ((Perishable) p).isExpired()) {
                expired.add(p);
            }
        }
        return expired;
    }

    public List<Product> shippableProducts() {
        List<Product> shippable = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Shippable) {
                shippable.add(p);
            }
        }
        return shippable;
    }

    public void remove(UUID id) {
        products.removeIf(p -> p.uuid().equals(id));
    }
}