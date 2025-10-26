package com.example;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, Category> CACHE = new HashMap<>();
    private final String name;

    private Category(String name) {
        this.name = name;
    }

    public static Category of(String name) {
        if (name == null) throw new IllegalArgumentException("Category name can't be null");
        name = name.trim();
        if (name.isEmpty()) throw new IllegalArgumentException("Category name can't be blank");
        String normalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return CACHE.computeIfAbsent(normalized, Category::new);
    }

    public String name() {
        return name;
    }
}