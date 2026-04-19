package org.example.compito1904.controller;

import lombok.RequiredArgsConstructor;
import org.example.compito1904.entities.Viaggio;
import org.example.compito1904.payloads.ViaggioDTO;
import org.example.compito1904.services.ViaggioService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/viaggi")
@RequiredArgsConstructor
public class ViaggioController {


    private final ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio createViaggio(@RequestBody @Validated ViaggioDTO viaggioDTO) {
        Viaggio nuovoViaggio = new Viaggio();
        nuovoViaggio.setDestinazione(viaggioDTO.destinazione());
        nuovoViaggio.setStatoViaggio(viaggioDTO.statoViaggio());
        nuovoViaggio.setData(viaggioDTO.data());
        return viaggioService.save(nuovoViaggio);
    }

    @GetMapping
    public Page<Viaggio> getAllViaggi(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            @RequestParam(defaultValue = "data") String sortBy
    ) {
        return viaggioService.findAll(size, page, sortBy);
    }


    @GetMapping("/{id}")
    public Viaggio getById(@PathVariable Long id) {
        return viaggioService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio updateViaggio(@RequestBody @Validated ViaggioDTO viaggioDTO, @PathVariable Long id) {
        Viaggio viaggioModificato = new Viaggio();
        viaggioModificato.setDestinazione(viaggioDTO.destinazione());
        viaggioModificato.setStatoViaggio(viaggioDTO.statoViaggio());
        viaggioModificato.setData(viaggioDTO.data());
        return viaggioService.update(id, viaggioModificato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void abbattiMezzoDiTrasporto(@PathVariable Long id) {
        viaggioService.deleteById(id);
    }
}