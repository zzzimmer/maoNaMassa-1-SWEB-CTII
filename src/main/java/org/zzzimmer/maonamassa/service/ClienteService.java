package org.zzzimmer.maonamassa.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzzimmer.maonamassa.dto.ClienteDTO;
import org.zzzimmer.maonamassa.dto.ResponseClienteDTO;
import org.zzzimmer.maonamassa.mapper.ClienteMapper;
import org.zzzimmer.maonamassa.model.Cliente;
import org.zzzimmer.maonamassa.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    public ResponseClienteDTO save(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToCliente(clienteDTO);
        return clienteMapper.clienteToResponseClienteDto(clienteRepository.save(cliente));
    }

    public List<ResponseClienteDTO> findAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream()
                .map(cliente -> clienteMapper.clienteToResponseClienteDto(cliente))
                .toList();
    }

    public ResponseClienteDTO findById(Long id) {
        return clienteMapper.
                clienteToResponseClienteDto(clienteRepository.findById(id)
                        .orElseThrow());
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    public ResponseClienteDTO update(Long id, @Valid ClienteDTO clienteDTO) {
        Cliente clienteDoBanco = clienteRepository.findById(id).orElseThrow();
        clienteMapper.updateCliente(clienteDTO,clienteDoBanco);
        return clienteMapper.clienteToResponseClienteDto(clienteDoBanco);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
