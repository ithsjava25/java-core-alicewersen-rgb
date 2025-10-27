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
        if (name.isBlank()) throw new IllegalArgumentException("Category name can't be blank");

        String normalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return CACHE.computeIfAbsent(normalized, Category::new);
    }

    public String getName() {
        return name;
    }

    public String name() {
        return name;
    }

    public boolean equalsIgnoreCase(String category) {
        if (category == null) return false;
        return name.equalsIgnoreCase(category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Category)) return false;
        Category other = (Category) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "'}";
    }
}