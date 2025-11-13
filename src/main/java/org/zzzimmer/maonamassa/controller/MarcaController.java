package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.model.Veiculo;
import org.zzzimmer.maonamassa.repository.MarcaRespository;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaRespository marcaRespository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Marca> create( @Valid @RequestBody Marca marca){
        marcaRespository.save(marca);
        return ResponseEntity.ok().body(marca);
    }

    @GetMapping
    public ResponseEntity<List<Marca>> read(){
        return ResponseEntity.ok().body(marcaRespository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> readById(@PathVariable Long id){
        return ResponseEntity.ok().body(marcaRespository.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, @Valid @RequestBody Marca marca){
        if (!marcaRespository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            marca.setId(id);
            Marca marcaAtualizada = marcaRespository.save(marca);
            return ResponseEntity.ok().body(marcaAtualizada);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        if (!marcaRespository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            marcaRespository.deleteById(id);
            return ResponseEntity.noContent().build();
            //retorna 204
        }
    }

}
