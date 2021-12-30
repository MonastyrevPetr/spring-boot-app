package ru.gb.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDto {
  private Long id;
  private String title;
  private String cost;
}
