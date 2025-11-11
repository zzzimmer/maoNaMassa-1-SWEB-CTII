package org.zzzimmer.maonamassa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.model.Cliente;
import org.zzzimmer.maonamassa.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteRepository.save(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> read(){
        return ResponseEntity.ok().body(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> readById(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteRepository.getReferenceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            cliente.setId(id);
            Cliente clienteAtualizado = clienteRepository.save(cliente);
            return ResponseEntity.ok().body(clienteAtualizado);
        }
    }

    @DeleteMapping("/{id})")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        if (!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
