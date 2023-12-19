package com.livraria.livrariavendalivros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livrariavendalivros.exception.VendaLivroNotFoundException;
import com.livraria.livrariavendalivros.model.Livro;
import com.livraria.livrariavendalivros.model.VendaLivro;
import com.livraria.livrariavendalivros.repository.VendaLivroRepository;
import com.livraria.livrariavendalivros.service.VendaLivroService;

@Service
public class VendaLivroServiceImpl implements VendaLivroService {

    @Autowired
    VendaLivroRepository vendaLivroRepository;

    @Override
    public List<VendaLivro> getAll() {
        return vendaLivroRepository.findAll();
    }

    @Override
    public VendaLivro create(VendaLivro livro) {
        return vendaLivroRepository.save(livro);
    }

    @Override
    public void deleteById(String id) {
        vendaLivroRepository.deleteById(id);
    }

    @Override
    public VendaLivro update(String id, VendaLivro livro) {
        livro.setId(id);
        return create(livro);
    }

    @Override
    public VendaLivro getById(String id) {
        return vendaLivroRepository.findById(id).orElseThrow(VendaLivroNotFoundException::new);
    }
    
}
