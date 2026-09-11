package br.edu.atitus.product_api.dtos;

import br.edu.atitus.product_api.entities.ProductEntity;

public record ProductResponse(
        Long id,
        String brand,
        String model,
        String description,
        String currency,
        double price,
        String image,

        String environment,
        String promotionMessage,
        String targetCurrency,
        double convertedPrice
) {
    public static ProductResponse fromEntity(ProductEntity entity, String environment, String promotionMessage, String targetCurrency, double convertedPrice) {
        return new ProductResponse(
                entity.getId(),
                entity.getDescription(),
                entity.getBrand(),
                entity.getModel(),
                entity.getCurrency(),
                entity.getPrice(),
                entity.getImage(),
                environment,
                promotionMessage,
                targetCurrency,
                convertedPrice
                );
    }
}