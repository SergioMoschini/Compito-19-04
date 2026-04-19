package org.example.compito1904.services;

import org.example.compito1904.entities.Dipendente;
import org.example.compito1904.exceptions.EmailGiaInUsoException;
import org.example.compito1904.exceptions.NonTrovatoException;
import org.example.compito1904.repositories.DipendenteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;

    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }
    public Dipendente save(Dipendente dipendente) {
        if (!dipendenteRepository.existsByEmail(dipendente.getEmail())) {
            return dipendenteRepository.save(dipendente);
        } else {
            throw new EmailGiaInUsoException("questa mail esiste gia");
        }

    }
   public void deleteById(UUID id) {
        if (dipendenteRepository.existsById(id)) {dipendenteRepository.deleteById(id);}
        else {throw new NonTrovatoException(id);}
}

    public Dipendente findById(UUID id) {
   return dipendenteRepository.findById(id).orElseThrow(() -> new NonTrovatoException(id));
    }

    public Page<Dipendente> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable
        );
    }

    public Dipendente update(UUID id, Dipendente dipendente) {
        Dipendente dipendenteDaModificare = findById(id);
        dipendenteDaModificare.setEmail(dipendente.getEmail());
        dipendenteDaModificare.setName(dipendente.getName());
        dipendenteDaModificare.setSurname(dipendente.getSurname());
        dipendenteDaModificare.setUsername(dipendente.getUsername());
        dipendenteDaModificare.setEmail(dipendente.getEmail());
return dipendenteRepository.save(dipendenteDaModificare);

    }

}
