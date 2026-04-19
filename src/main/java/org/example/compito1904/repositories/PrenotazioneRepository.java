package org.example.compito1904.repositories;

import org.example.compito1904.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository <Prenotazione, Long > {
   boolean existsByDipendenteIdAndViaggioData (UUID id, LocalDate data);
}
