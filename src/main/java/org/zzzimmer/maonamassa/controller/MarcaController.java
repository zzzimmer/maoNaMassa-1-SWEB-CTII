package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.dto.MarcaDTO;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.model.Veiculo;
import org.zzzimmer.maonamassa.repository.MarcaRespository;
import org.zzzimmer.maonamassa.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaRespository marcaRespository;

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MarcaDTO> create(@Valid @RequestBody MarcaDTO marcaDTO){
        marcaService.save(marcaDTO);
        return ResponseEntity.ok().body(marcaDTO);
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> read(){
        return ResponseEntity.ok().body(marcaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> readById(@PathVariable Long id){
        return ResponseEntity.ok().body(marcaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> update(@PathVariable Long id, @Valid @RequestBody MarcaDTO marcaDTO){
        return ResponseEntity.ok(marcaService.update(id, marcaDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        return ResponseEntity.ok(marcaService.delete(id));
    }

}
