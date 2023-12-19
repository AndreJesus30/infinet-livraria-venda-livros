
package com.livraria.livrariavendalivros.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.livraria.livrariavendalivros.model.VendaLivro;

@Repository
public interface VendaLivroRepository extends MongoRepository<VendaLivro, String> {}