package org.example.compito1904.controller;

import lombok.RequiredArgsConstructor;
import org.example.compito1904.entities.Dipendente;
import org.example.compito1904.entities.Prenotazione;
import org.example.compito1904.entities.Viaggio;
import org.example.compito1904.payloads.PrenotazioneDTO;
import org.example.compito1904.services.DipendenteService;
import org.example.compito1904.services.PrenotazioneService;
import org.example.compito1904.services.ViaggioService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
@RequiredArgsConstructor
public class PrenotazioneController {





    private final PrenotazioneService prenotazioneService;
    private final ViaggioService viaggioService;
    private final DipendenteService dipendenteService ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO) {
        Prenotazione nuovoPrenotazione = new Prenotazione();
        Dipendente dipendente = dipendenteService.findById(prenotazioneDTO.idDipendente());
        Viaggio viaggio = viaggioService.findById(prenotazioneDTO.idViaggio());
        nuovoPrenotazione.setPreferenze(prenotazioneDTO.preferenze());
        return prenotazioneService.save(nuovoPrenotazione);
    }
    @GetMapping
    public Page<Prenotazione> getAllPrenotazioni(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            @RequestParam(defaultValue = "dataPrenotazione") String sortBy
    ) {return prenotazioneService.findAll(size, page, sortBy);}


    @GetMapping("/{id}")
    public Prenotazione getById(@PathVariable Long id) {
        return prenotazioneService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione updatePrenotazione(@RequestBody @Validated PrenotazioneDTO prenotazioneDTO, @PathVariable Long id)
    {
        Prenotazione prenotazioneModificata = new Prenotazione();

        prenotazioneModificata.setPreferenze(prenotazioneDTO.preferenze());
        return prenotazioneService.update(id, prenotazioneModificata);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void faiDiventare404LaPrenotazione(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
    }
}