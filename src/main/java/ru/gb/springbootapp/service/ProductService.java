package ru.gb.springbootapp.service;

import org.springframework.stereotype.Service;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product findId(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {productRepository.deleteById(id);}
}
