package org.example.compito1904.services;

import org.example.compito1904.entities.Prenotazione;
import org.example.compito1904.repositories.DipendenteRepository;
import org.example.compito1904.repositories.PrenotazioneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }
    public Prenotazione save(Prenotazione prenotazione) {
        if (!prenotazioneRepository.existsByDipendenteIdAndViaggioData(prenotazione.getDipendente().getId(), prenotazione.getViaggio().getData())) {
            return prenotazioneRepository.save(prenotazione);
        } else {
            throw new RuntimeException("questo utente ha gia una prenotazione in questa data");
        }

    }
    public void deleteById(Long id) {
        if (prenotazioneRepository.existsById(id)) {prenotazioneRepository.deleteById(id);}
        else {throw new RuntimeException("questa prenotazione non esiste");}
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("prenotazione non trovata"));
    }

    public Page<Prenotazione> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return prenotazioneRepository.findAll(pageable
        );
    }

    public Prenotazione update(Long id, Prenotazione prenotazione) {
        Prenotazione prenotazioneDaModificare = findById(id);
        prenotazioneDaModificare.setPreferenze(prenotazione.getPreferenze());
        prenotazioneDaModificare.setDataPrenotazione(prenotazione.getDataPrenotazione());

        return prenotazioneRepository.save(prenotazioneDaModificare);

    }
}
