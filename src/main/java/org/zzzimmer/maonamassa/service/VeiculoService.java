package org.zzzimmer.maonamassa.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzimmer.maonamassa.dto.ResponseVeiculoDTO;
import org.zzzimmer.maonamassa.dto.VeiculoDTO;
import org.zzzimmer.maonamassa.model.Veiculo;
import org.zzzimmer.maonamassa.repository.ClienteRepository;
import org.zzzimmer.maonamassa.repository.CorRepository;
import org.zzzimmer.maonamassa.repository.ModeloRepository;
import org.zzzimmer.maonamassa.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CorRepository corRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Veiculo manualVeiculoMapper(VeiculoDTO veiculoDTO){

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modeloRepository.findById(
                veiculoDTO.modelo_id())
                .orElseThrow(()-> new EntityNotFoundException("Modelo não está presente no repositório")));
        veiculo.setCor(corRepository.findById(
                veiculoDTO.cor_id()).orElseThrow(() -> new EntityNotFoundException("Cor não está presente no repositório"))
        );
        veiculo.setPlaca(veiculoDTO.placa());
        veiculo.setObservacoes(veiculoDTO.observacoes());
        veiculo.setProprietario(clienteRepository.findById(
                veiculoDTO.proprietario_id()).orElseThrow());

        return veiculo;
    }


    @Transactional
    public ResponseVeiculoDTO save(@Valid VeiculoDTO veiculoDTO){

        Veiculo veiculo = manualVeiculoMapper(veiculoDTO);
        Long id = veiculoRepository.save(veiculo).getId();

        ResponseVeiculoDTO responseVeiculoDTO = new ResponseVeiculoDTO(
                id,
                veiculoDTO.placa(),
                veiculoDTO.observacoes(),
                veiculoDTO.cor_id(),
                veiculoDTO.modelo_id(),
                veiculoDTO.proprietario_id()
        );

        return responseVeiculoDTO;
    }

}
