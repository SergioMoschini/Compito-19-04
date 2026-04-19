package org.example.compito1904.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DipendenteDTO(
        @NotBlank( message = "Campo obbligatorio")
        @Size( min = 5, max = 16, message = "Il tuo username deve essere compreso tra 5 e 16 caratteri")
        String username,
        @NotBlank( message = "Nome obbligatorio" )
        String name,
        @NotBlank( message = "Cognome obbligatorio")
        String surname,
        @Email (message = "Inserisci un indirizzo email valido")
        @NotBlank( message = "Email obbligatoria")
        String email
        ) {
}
