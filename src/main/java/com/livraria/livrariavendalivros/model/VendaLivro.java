package com.livraria.livrariavendalivros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "vendalivros")
public class VendaLivro {

    @Id
    String id;
    String customer;
    String idLivro;
    int amount;
    
    public VendaLivro(String customer, String idLivro, int amount) {
        this.customer = customer;
        this.idLivro = idLivro;
        this.amount = amount;
    }
    

}
