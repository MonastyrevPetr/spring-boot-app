package ru.gb.springbootapp.repository;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.gb.springbootapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class CartRepository {
    private List<Product> products;
    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public void save(Product product) {
        if (product != null){
            products.add(product);
        }
    }

    public Product findById(Long id) {
        for (Product product:products){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        products.remove(findById(id));
    }
}

