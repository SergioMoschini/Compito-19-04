package org.example.compito1904.exceptions;

import java.util.List;

public class ErroreDiValidazioneException  extends RuntimeException {

        private List<String> errors;

        public ErroreDiValidazioneException(String message) {
            super(message);
        }

        public ErroreDiValidazioneException(List<String> errors) {
            super("Lista degli errori di validazione: ");
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }
    }

