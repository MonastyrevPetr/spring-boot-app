package ru.gb.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.springbootapp.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
  private String title;
  private String cost;

  public ProductDto(Product product){
    title = product.getTitle();
    cost = product.getCost().toString();
  }
}
