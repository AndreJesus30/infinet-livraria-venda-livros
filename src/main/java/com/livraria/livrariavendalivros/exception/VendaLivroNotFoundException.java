package com.livraria.livrariavendalivros.exception;

public class VendaLivroNotFoundException extends RuntimeException  {
    public VendaLivroNotFoundException () {

    }

    public VendaLivroNotFoundException(String message) {
        super(message);
    }
}
