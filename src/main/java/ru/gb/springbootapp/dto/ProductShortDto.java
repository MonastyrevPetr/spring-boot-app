package ru.gb.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductShortDto {
    private String title;
    private Integer cost;
}
