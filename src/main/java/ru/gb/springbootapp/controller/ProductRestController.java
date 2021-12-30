package ru.gb.springbootapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.gb.springbootapp.converter.ProductConverter;
import ru.gb.springbootapp.dto.ProductDto;
import ru.gb.springbootapp.dto.ProductShortDto;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.gb.springbootapp.converter.ProductConverter.*;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProduct(){
        return productService.getAll().stream().map(ProductConverter::productToProductDto).collect(Collectors.toList());
    }

    @GetMapping("/info/{id}")
    public ProductDto getProductInfo(@PathVariable Long id){
        return productToProductDto(productService.findId(id));
    }

    @PostMapping("/add")
    public ProductShortDto saveProduct(@RequestBody ProductShortDto productShortDto){
        Product product = productShortDtoToProduct(productShortDto);
        productService.save(product);
        return productToProductShotDto(product);
    }

}
