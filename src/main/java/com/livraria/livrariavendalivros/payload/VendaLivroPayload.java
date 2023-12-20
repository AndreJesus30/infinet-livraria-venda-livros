package com.livraria.livrariavendalivros.payload;

import lombok.Data;
import java.util.List;

@Data
public class VendaLivroPayload {
    private String customer;
    private List<String> livrosId;
    private int amount;

    public List<String> getLivrosId() {
        return livrosId;
    }

    public void setLivrosId(List<String> livrosId) {
        this.livrosId = livrosId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
