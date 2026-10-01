package br.edu.atitus.currency_api.services;

import br.edu.atitus.currency_api.dtos.CurrencyResponse;

public interface CurrencyService {

    CurrencyResponse findBySourceCurrencyAndTargetCurrency(
            String sourceCurrency,
            String targetCurrency
    ) throws Exception;

}