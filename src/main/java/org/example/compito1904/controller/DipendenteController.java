package org.example.compito1904.controller;

import lombok.RequiredArgsConstructor;
import org.example.compito1904.entities.Dipendente;
import org.example.compito1904.payloads.DipendenteDTO;
import org.example.compito1904.services.DipendenteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
@RequiredArgsConstructor
public class DipendenteController {

    private final DipendenteService dipendenteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@RequestBody @Validated DipendenteDTO dipendenteDTO) {
        Dipendente nuovoDipendente = new Dipendente();
        nuovoDipendente.setUsername(dipendenteDTO.username());
        nuovoDipendente.setName(dipendenteDTO.name());
        nuovoDipendente.setSurname(dipendenteDTO.surname());
        nuovoDipendente.setEmail(dipendenteDTO.email());
        return dipendenteService.save(nuovoDipendente);
    }
    @GetMapping
    public Page<Dipendente> getAllDipendenti(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            @RequestParam(defaultValue = "username") String sortBy
    ) {return dipendenteService.findAll(size, page, sortBy);}


@GetMapping("/{id}")
public Dipendente getById(@PathVariable UUID id) {
 return dipendenteService.findById(id);
}

@PutMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Dipendente updateDipendente(@RequestBody @Validated DipendenteDTO dipendenteDTO, @PathVariable UUID id)
{
    Dipendente dipendenteModificato = new Dipendente();
    dipendenteModificato.setUsername(dipendenteDTO.username());
    dipendenteModificato.setName(dipendenteDTO.name());
    dipendenteModificato.setSurname(dipendenteDTO.surname());
    dipendenteModificato.setEmail(dipendenteDTO.email());
    return dipendenteService.update(id, dipendenteModificato);
}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sterminaIlDipendente(@PathVariable UUID id) {
        dipendenteService.deleteById(id);
    }
}