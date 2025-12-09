package org.zzzimmer.maonamassa.mapper;


import org.mapstruct.*;
import org.zzzimmer.maonamassa.dto.ModeloDTO;
import org.zzzimmer.maonamassa.dto.ResponseModeloDTO;
import org.zzzimmer.maonamassa.model.Modelo;

@Mapper(componentModel = "spring")
public interface ModeloMapper {

    @Mapping(source = "marca.name", target = "marcaName")
    @Mapping(source = "motor.potencia", target = "motorPotencia")
    @Mapping(source = "motor.ETipoCombustivel", target = "motorETipoDeCombustivel")
    @Mapping(source = "ECategoria", target = "eCategoria")
    ResponseModeloDTO modeloToResponseModeloDto(Modelo modelo);

    // metodo abaixo com problemas
//    @Mapping(source = "potencia", target = "motor.potencia")
//    @Mapping(source = "eTipoCombustivel", target = "motor.ETipoCombustivel")
//    @Mapping(source = "eCategoria", target = "ECategoria")
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "marca", ignore = true)
//    Modelo dtoToModelo(ModeloDTO modeloDTO);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelo (ModeloDTO modeloDTO, @MappingTarget Modelo modelo);
}
