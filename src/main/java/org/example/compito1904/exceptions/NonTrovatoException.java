package org.example.compito1904.exceptions;

import java.util.UUID;

public class NonTrovatoException extends RuntimeException {
    public NonTrovatoException(Long id) {
        super("non e' stato trovato nulla con l'id: " + id );
    }
    public NonTrovatoException(UUID id) {
        super("non e' stato trovato nulla che corrispondesse al record con id: " + id );
    }
}