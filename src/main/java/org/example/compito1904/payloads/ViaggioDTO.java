package org.example.compito1904.payloads;

import jakarta.validation.constraints.NotBlank;
import org.example.compito1904.entities.StatoViaggio;

import java.time.LocalDate;

public record ViaggioDTO(
        @NotBlank( message = "Campo obbligatorio")
        String destinazione,
        @NotBlank( message = "data obbligatoria" )
        LocalDate data,
        @NotBlank( message = "stato ?")
        StatoViaggio statoViaggio
) {
}
