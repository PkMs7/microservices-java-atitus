package br.edu.atitus.currency_api.servicesimpl;

import br.edu.atitus.currency_api.dtos.CurrencyResponse;
import br.edu.atitus.currency_api.repositories.CurrencyRepository;
import br.edu.atitus.currency_api.services.CurrencyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceJpa implements CurrencyService {

    private final CurrencyRepository repository;

    public CurrencyServiceJpa(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Value("${server.port:8080}")
    private String serverPort;

    @Override
    public CurrencyResponse findBySourceCurrencyAndTargetCurrency(
            String sourceCurrency,
            String targetCurrency
    ) throws Exception {

        var currency = repository
                .findBySourceCurrencyAndTargetCurrency(
                        sourceCurrency,
                        targetCurrency
                )
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Cotação não encontrada"
                        )
                );

        String environment =
                "Currency API running in Port: " + serverPort;

        return new CurrencyResponse(
                currency.getSourceCurrency(),
                currency.getTargetCurrency(),
                currency.getConversionRate(),
                environment
        );
    }
}