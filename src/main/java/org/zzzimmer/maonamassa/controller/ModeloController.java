package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.dto.ModeloDTO;
import org.zzzimmer.maonamassa.dto.ResponseModeloDTO;
import org.zzzimmer.maonamassa.mapper.ModeloMapper;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.model.Modelo;
import org.zzzimmer.maonamassa.repository.ModeloRepository;
import org.zzzimmer.maonamassa.service.ModeloService;

import java.util.List;

@RestController
@RequestMapping("/modelo")
public class ModeloController {


    @Autowired
    private ModeloMapper modeloMapper;

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseModeloDTO> create (@Valid @RequestBody ModeloDTO modeloDTO){
        return ResponseEntity.ok(modeloService.save(modeloDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseModeloDTO>> read(){
        return ResponseEntity.ok().body(
                modeloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModeloDTO> readById(@PathVariable Long id){
//        if (!modeloRepository.existsById(id)){
//            return ResponseEntity.noContent().build();
//        }else {
//            return ResponseEntity.ok().body(modeloRepository.findById(id).orElseThrow());
//        }
//    }
        return ResponseEntity.ok()
                .body(modeloService.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseModeloDTO> update(@PathVariable Long id, @Valid @RequestBody ModeloDTO modeloDTO){
        // precisa fazer isso? Visando tirar o acesso do controller de repository, criei esse metodo em service
        if (!modeloService.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(modeloService.update(id, modeloDTO));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!modeloService.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            modeloService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }




}
