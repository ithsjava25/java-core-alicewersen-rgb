// An Interface for products that can expire, such as medicine or food.
// This Interface defines an expiration date. It also includes a helper method.

package com.example;

import java.time.LocalDate;

public interface Perishable {
    LocalDate expirationDate();

    default boolean isExpired() {
        return expirationDate().isBefore(LocalDate.now());
    }
}