package ru.gb.springbootapp.service;

import org.springframework.stereotype.Service;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.repository.CartRepository;
import ru.gb.springbootapp.repository.ProductRepository;

import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Product> getAll(){
        return cartRepository.getProducts();
    }

    public void save(Product product){
        cartRepository.save(product);
    }

    public Product findId(Long id){
        return cartRepository.findById(id);
    }

    public void deleteById(Long id) {cartRepository.deleteById(id);}
}
