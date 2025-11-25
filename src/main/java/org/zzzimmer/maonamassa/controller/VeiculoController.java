package org.zzzimmer.maonamassa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zzzimmer.maonamassa.model.Cor;
import org.zzzimmer.maonamassa.model.Veiculo;
import org.zzzimmer.maonamassa.repository.CorRepository;
import org.zzzimmer.maonamassa.repository.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CorRepository corRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Veiculo> create(@Valid @RequestBody Veiculo veiculo){
        Cor corRecebida = veiculo.getCor();
        //cor vem só com nome no json
        if (corRecebida != null && corRecebida.getNome() != null && corRecebida.getId() == null){
            Cor corSalva = corRepository.findByNome(corRecebida.getNome())
                    .orElseGet(() -> corRepository.save(corRecebida));

        veiculo.setCor(corSalva);
        }
        veiculoRepository.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> read(){
        return ResponseEntity.ok(veiculoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> readById(@PathVariable Long id){
        return ResponseEntity.ok(veiculoRepository.findById(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo){
        if (veiculoRepository.existsById(id)){
            veiculo.setId(id);
            return ResponseEntity.ok(veiculoRepository.save(veiculo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (!veiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            veiculoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
            //noContent -> Devolve o codigo 204 - sucesso mas sem conteúdo.
        }
    }

}
