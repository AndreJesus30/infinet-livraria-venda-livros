
 package com.livraria.livrariavendalivros.service;
 import java.util.List;

 import org.springframework.cloud.openfeign.FeignClient;
 import org.springframework.web.bind.annotation.GetMapping;

 import com.livraria.livrariavendalivros.model.Livro;

 @FeignClient(name = "GERENCIAMENTO-LIVRO", url = "http://localhost:9090/api/livro/")
 public interface GerenciamentoLivroService {

     @GetMapping
     List<Livro> getAllLivros();
 }
