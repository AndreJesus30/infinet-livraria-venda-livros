package com.livraria.livrariavendalivros.service;

import java.util.List;

import com.livraria.livrariavendalivros.model.VendaLivro;

public interface VendaLivroService {

    List<VendaLivro> getAll();

    VendaLivro create(VendaLivro livro);

    void deleteById(String id);

    VendaLivro update(String id, VendaLivro livro);

    VendaLivro getById(String id); 
}
