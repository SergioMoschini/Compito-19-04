package org.example.compito1904.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsListDTO(String messaggio, LocalDateTime timestamp, List<String> errors) {
}
