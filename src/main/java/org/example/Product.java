package org.example;

import java.math.BigDecimal;

public record Product(String name, String brand, String category, BigDecimal price) {
}
