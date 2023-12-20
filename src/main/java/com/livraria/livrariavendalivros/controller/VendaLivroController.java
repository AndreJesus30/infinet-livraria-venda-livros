package com.livraria.livrariavendalivros.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.livraria.livrariavendalivros.model.Livro;
import com.livraria.livrariavendalivros.payload.VendaLivroPayload;
import com.livraria.livrariavendalivros.service.GerenciamentoLivroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livrariavendalivros.exception.VendaLivroNotFoundException;
import com.livraria.livrariavendalivros.model.VendaLivro;
import com.livraria.livrariavendalivros.payload.ResponsePayload;
import com.livraria.livrariavendalivros.service.VendaLivroService;

@RestController
@RequestMapping("/")
public class VendaLivroController {
    
    @Autowired
    VendaLivroService vendaLivroService;

     @Autowired
     GerenciamentoLivroService gerenciamentoLivroService;

    Logger LOGGER = LoggerFactory.getLogger(VendaLivroController.class);

     @GetMapping("/livros")
     public List<Livro> getAllLivros(){
         List<Livro> all = gerenciamentoLivroService.getAllLivros();
         LOGGER.info("GET ALL:" + all);
         return all;
     }

    @GetMapping
    public List<VendaLivro> getAll(){
        List<VendaLivro> all = vendaLivroService.getAll();
        LOGGER.info("GET ALL:" + all);
        return all;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try{
            VendaLivro vendaLivro = vendaLivroService.getById(id);
            LOGGER.info("GET BY ID: "+ vendaLivro);
            return ResponseEntity.ok(vendaLivro);
        }catch (VendaLivroNotFoundException ex){
            ResponsePayload notFound = new ResponsePayload();
            notFound.setMessage("Not Found");
            notFound.setDateTime(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        LOGGER.info("DELETE: " + id);
        vendaLivroService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<VendaLivro> create(@RequestBody VendaLivroPayload vendaLivroPayload){
        LOGGER.info("CREATED: " + vendaLivroPayload.getLivrosId());


        VendaLivro venda = new VendaLivro(
                vendaLivroPayload.getCustomer(),
                vendaLivroPayload.getLivrosId().get(0),
                vendaLivroPayload.getAmount()
        );

        vendaLivroService.create(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody VendaLivro vendaLivro){
        VendaLivro updated = vendaLivroService.update(id, vendaLivro);
        LOGGER.info("UPDATE: " + updated);
    }

}
