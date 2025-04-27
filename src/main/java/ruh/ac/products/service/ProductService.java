package ruh.ac.products.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruh.ac.products.entity.Product;
import ruh.ac.products.repository.ProductRepository;
import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired // dependency injection
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(long id){
        productRepository.deleteById(id);
    }
}
