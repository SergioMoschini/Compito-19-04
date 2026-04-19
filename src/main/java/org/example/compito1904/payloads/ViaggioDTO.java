package org.example.compito1904.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.compito1904.entities.StatoViaggio;

import java.time.LocalDate;

public record ViaggioDTO(
        @NotBlank( message = "Campo obbligatorio")
        String destinazione,
        @NotNull( message = "data obbligatoria" )
        LocalDate data,
        @NotNull( message = "stato ?")
        StatoViaggio statoViaggio
) {
}
