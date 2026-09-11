package br.edu.atitus.product_api.services;

import br.edu.atitus.product_api.dtos.ProductRequest;
import br.edu.atitus.product_api.dtos.ProductResponse;
import br.edu.atitus.product_api.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductResponse findById(Long id, String targetCurrency) throws Exception;
    Page<ProductResponse> findAll(Pageable pageable, String targetCurrency) throws Exception;
    ProductEntity save(ProductRequest request) throws Exception;
}