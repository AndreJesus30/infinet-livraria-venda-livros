package com.livraria.livrariavendalivros.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {
    private String id;
    private String name;
    private String author;
    private BigDecimal price;
}
