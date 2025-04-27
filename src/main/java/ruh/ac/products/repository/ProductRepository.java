package ruh.ac.products.repository;

import org.springframework.data.repository.CrudRepository;
import ruh.ac.products.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
