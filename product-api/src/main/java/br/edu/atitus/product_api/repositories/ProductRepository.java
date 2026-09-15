package br.edu.atitus.product_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.atitus.product_api.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
