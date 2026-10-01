package br.edu.atitus.currency_api.dtos;

public record CurrencyResponse(
        String sourceCurrency,
        String targetCurrency,
        Double conversionRate,
        String environment
) {
}