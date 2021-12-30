package ru.gb.springbootapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.springbootapp.converter.ProductConverter;
import ru.gb.springbootapp.dto.CartShortDto;
import ru.gb.springbootapp.dto.ProductDto;
import ru.gb.springbootapp.dto.ProductShortDto;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.service.CartService;
import ru.gb.springbootapp.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.gb.springbootapp.converter.ProductConverter.*;

@RestController
@RequestMapping("/cart")
public class CartRestController {

    private final ProductService productService;
    private final CartService cartService;

    public CartRestController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProduct(){
        return cartService.getAll().stream().map(ProductConverter::productToProductDto).collect(Collectors.toList());
    }

    @GetMapping("/info/{id}")
    public ProductDto getProductInfo(@PathVariable Long id){
        return productToProductDto(cartService.findId(id));
    }

    @PostMapping("/add")
    public ProductShortDto saveProduct(@RequestBody CartShortDto cartShortDto){
        Product product = productService.findId(cartShortDto.getId());
        cartService.save(product);
        return productToProductShotDto(product);
    }

    @DeleteMapping("/delete/{id}")
    public ProductShortDto deleteProduct(@RequestBody CartShortDto cartShortDto){
        cartService.deleteById(cartShortDto.getId());
        return productToProductShotDto(productService.findId(cartShortDto.getId()));
    }

}
