// An Interface for products that can be shipped to customers.
// This Interface also includes methods for getting the weight of the products and calculates the cost of the shipping.

package com.example;

import java.math.BigDecimal;

public interface Shippable {
    double weight();
    BigDecimal calculateShippingCost();
}