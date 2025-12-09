package org.zzzimmer.maonamassa.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zzzimmer.maonamassa.dto.ModeloDTO;
import org.zzzimmer.maonamassa.dto.ResponseModeloDTO;
import org.zzzimmer.maonamassa.mapper.MarcaMapper;
import org.zzzimmer.maonamassa.mapper.ModeloMapper;
import org.zzzimmer.maonamassa.model.Marca;
import org.zzzimmer.maonamassa.model.Modelo;
import org.zzzimmer.maonamassa.repository.MarcaRespository;
import org.zzzimmer.maonamassa.repository.ModeloRepository;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private MarcaRespository marcaRespository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private MarcaMapper marcaMapper;

    @Autowired
    ModeloMapper modeloMapper;


//    @Transactional
//    public ResponseModeloDTO save(@Valid ModeloDTO modeloDTO) {
//
//        Marca marca = marcaRespository.findById(modeloDTO.marcaId()).orElseThrow();
//        Modelo modelo = modeloMapper.dtoToModelo(modeloDTO);
//        modelo.setMarca(marca);
//        modeloRepository.save(modelo);
//
//        return modeloMapper.modeloToResponseModeloDto(modelo);
//    }

    public Modelo manualModeloMapper(ModeloDTO modeloDTO){

        Modelo modelo = new Modelo();
        modelo.setDescricao(modeloDTO.descricao());
        modelo.setECategoria(modeloDTO.eCategoria());
        modelo.getMotor().setPotencia(modeloDTO.potencia());
        modelo.getMotor().setPotencia(modeloDTO.potencia());
        modelo.getMotor().setETipoCombustivel(modeloDTO.eTipoCombustivel());

        return modelo;
    }

    @Transactional
    public ResponseModeloDTO save(@Valid ModeloDTO modeloDTO) {

        Marca marca = marcaRespository.findById(modeloDTO.marcaId()).orElseThrow();
        Modelo modelo = manualModeloMapper(modeloDTO);
        modelo.setMarca(marca);
        modeloRepository.save(modelo);

        return modeloMapper.modeloToResponseModeloDto(modelo);
    }

    public List<ResponseModeloDTO> findAll() {
        List<Modelo> modeloList = modeloRepository.findAll();
        return modeloList.stream().map(
                modelo -> modeloMapper.modeloToResponseModeloDto(modelo))
                .toList();
    }

    public ResponseModeloDTO findById(Long id) {
        return modeloMapper.modeloToResponseModeloDto(
                modeloRepository.findById(id).orElseThrow());
    }

    public boolean existsById(Long id) {
        return modeloRepository.existsById(id);
    }


    //todo tem um erro nesse méthodo. o Mapper não implementa a atualização de atributos alem da descricao
    public ResponseModeloDTO update(Long id, @Valid ModeloDTO modeloDTO) {
        Modelo modeloDoBanco = modeloRepository.findById(id).orElseThrow();
        modeloMapper.updateModelo(modeloDTO, modeloDoBanco);
        modeloRepository.save(modeloDoBanco);
        return modeloMapper.modeloToResponseModeloDto(modeloDoBanco);
    }

    public void delete(Long id) {
        modeloRepository.deleteById(id);
    }
}
