package org.example.compito1904.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PrenotazioneDTO(
        @NotNull( message = "Campo obbligatorio")
        UUID idDipendente,
        @NotNull( message = "Campo obbligatorio")
        Long idViaggio,
        @Size( max = 150, message = "hai preferenze ?")
        String preferenze
) {
}
