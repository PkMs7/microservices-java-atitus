package br.edu.atitus.product_api.controllers;

import br.edu.atitus.product_api.dtos.ProductResponse;
import br.edu.atitus.product_api.services.ProductService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(
            @PathVariable Long id,
            @RequestParam String targetCurrency
    ) throws Exception {
        var response = service.findById(id, targetCurrency);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
        @RequestParam String targetCurrency,
        @PageableDefault (size = 10, sort = "description", page = 0) Pageable pageable
    ) throws Exception {
        var response = service.findAll(pageable, targetCurrency);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<String> exeptionHandler(Exception e) {
        return ResponseEntity.status(500).body("Ops!!! Algo deu errado!");
    }
}