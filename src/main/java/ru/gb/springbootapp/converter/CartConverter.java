package ru.gb.springbootapp.converter;

import ru.gb.springbootapp.dto.CartShortDto;
import ru.gb.springbootapp.dto.ProductDto;
import ru.gb.springbootapp.dto.ProductShortDto;
import ru.gb.springbootapp.model.Product;

public class CartConverter {

    public static CartShortDto cartToCartShotDto(Product product){
        if (product==null){
            return null;
        }
        CartShortDto cartShortDto = new CartShortDto();
        cartShortDto.setId(product.getId());
        return cartShortDto;
    }
}
