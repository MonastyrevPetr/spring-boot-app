package ru.gb.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.springbootapp.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
  private Long id;
  private String title;
  private String cost;
}
