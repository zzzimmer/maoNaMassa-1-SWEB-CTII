package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.model.Modelo;
import org.zzzimmer.maonamassa.repository.ModeloRepository;

import java.util.List;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    ModeloRepository modeloRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Modelo> create (@Valid @RequestBody Modelo modelo){
        return ResponseEntity.ok().body(modeloRepository.save(modelo));
        //a implementação de save() retorna a entidade, só conferir.
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> read(){
        return ResponseEntity.ok().body(
                modeloRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> readById(@PathVariable Long id){
//        if (!modeloRepository.existsById(id)){
//            return ResponseEntity.noContent().build();
//        }else {
//            return ResponseEntity.ok().body(modeloRepository.findById(id).orElseThrow());
//        }
//    }
        return modeloRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> update(@PathVariable Long id, @Valid @RequestBody Modelo modelo){
        if (!modeloRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            modelo.setId(id);
            Modelo modeloAtualizado = modeloRepository.save(modelo);
            return ResponseEntity.ok().body(modeloAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!modeloRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            modeloRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }




}
