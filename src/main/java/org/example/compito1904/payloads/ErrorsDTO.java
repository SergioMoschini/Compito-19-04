package org.example.compito1904.payloads;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsDTO(String messaggio, LocalDateTime timestamp) {
}
