package ru.gb.springbootapp.converter;

import ru.gb.springbootapp.dto.ProductDto;
import ru.gb.springbootapp.dto.ProductShortDto;
import ru.gb.springbootapp.model.Product;

public class ProductConverter {

    public static ProductShortDto productToProductShotDto(Product product){
        if (product==null){
            return null;
        }
        ProductShortDto productShortDto = new ProductShortDto();
        productShortDto.setTitle(product.getTitle());
        productShortDto.setCost(product.getCost());
        return productShortDto;
    }

    public static Product productShortDtoToProduct(ProductShortDto productShortDto){
        if (productShortDto == null){
            return null;
        }
        Product product = new Product();
        product.setTitle(productShortDto.getTitle());
        product.setCost(productShortDto.getCost());
        return product;
    }

    public static ProductDto productToProductDto(Product product){
        if (product==null){
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setCost(product.getCost().toString());
        return productDto;
    }
}
