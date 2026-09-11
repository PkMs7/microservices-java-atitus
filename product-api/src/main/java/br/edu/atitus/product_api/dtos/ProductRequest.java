package br.edu.atitus.product_api.dtos;

public record ProductRequest(
        String brand,
        String model,
        String description,
        String currency,
        double price,
        String image
) {
}