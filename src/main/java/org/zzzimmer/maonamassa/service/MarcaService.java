package org.zzzimmer.maonamassa.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zzzimmer.maonamassa.dto.MarcaDTO;
import org.zzzimmer.maonamassa.mapper.MarcaMapper;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.repository.MarcaRespository;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRespository marcaRespository;

    @Autowired
    private MarcaMapper marcaMapper;

    public void save(@Valid MarcaDTO marcaDTO) {
        Marca marca = marcaMapper.dtoToMarca(marcaDTO);
        marcaRespository.save(marca);
    }

    public List<MarcaDTO> findAll() {
        List<Marca> marcaList = marcaRespository.findAll();
        return marcaList.stream()
                .map(marca -> marcaMapper.marcaToMarcaDTO(marca)).toList();
    }

    public MarcaDTO findById(Long id) {
        Marca marca = marcaRespository.findById(id).orElseThrow();
        return marcaMapper.marcaToMarcaDTO(marca);
    }

    public MarcaDTO update(Long id, @Valid MarcaDTO marcaDTO) {

        Marca marca = marcaRespository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

        marcaMapper.updateMarcaFromDTO(marcaDTO, marca);

        Marca marcaSalva = marcaRespository.save(marca);

        return marcaMapper.marcaToMarcaDTO(marcaSalva);
    }

    public Void delete(Long id) {

        Marca marca = marcaRespository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

        marcaRespository.delete(marca);

        return null;
    }
}
