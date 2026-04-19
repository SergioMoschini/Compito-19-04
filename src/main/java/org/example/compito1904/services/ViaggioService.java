package org.example.compito1904.services;

import org.example.compito1904.entities.Viaggio;
import org.example.compito1904.repositories.ViaggioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

    @Service
    public class ViaggioService {
        private final ViaggioRepository viaggioRepository;

        public ViaggioService(ViaggioRepository viaggioRepository) {
            this.viaggioRepository = viaggioRepository;
        }
        public Viaggio save(Viaggio viaggio) {
                return viaggioRepository.save(viaggio);
        }
        public void deleteById(Long id) {
            if (viaggioRepository.existsById(id)) {viaggioRepository.deleteById(id);}
            else {throw new RuntimeException("questo utente non esiste");}
        }

        public Viaggio findById(Long id) {
            return viaggioRepository.findById(id).orElseThrow(() -> new RuntimeException("utente non trovato"));
        }

        public Page<Viaggio> findAll(int size, int page, String sortBy) {
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
            return viaggioRepository.findAll(pageable
            );
        }

        public Viaggio update(Long id, Viaggio viaggio) {
            Viaggio viaggioDaModificare = findById(id);
            viaggioDaModificare.setData(viaggio.getData());
            viaggioDaModificare.setStatoViaggio(viaggio.getStatoViaggio());
            viaggioDaModificare.setDestinazione(viaggio.getDestinazione());
            return viaggioRepository.save(viaggioDaModificare);

        }

    }

