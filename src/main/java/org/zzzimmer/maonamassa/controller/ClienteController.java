package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.dto.ClienteDTO;
import org.zzzimmer.maonamassa.dto.ResponseClienteDTO;
import org.zzzimmer.maonamassa.model.Cliente;
import org.zzzimmer.maonamassa.repository.ClienteRepository;
import org.zzzimmer.maonamassa.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok().body(clienteService.save(clienteDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseClienteDTO>> read(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseClienteDTO> readById(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO){
        if (!clienteService.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            clienteService.update(id,clienteDTO);
            return ResponseEntity.ok().body(clienteService.update(id,clienteDTO));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        if (!clienteService.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

}
