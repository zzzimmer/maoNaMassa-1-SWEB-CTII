package org.zzzimmer.maonamassa.mapper;


import org.mapstruct.*;
import org.zzzimmer.maonamassa.dto.MarcaDTO;
import org.zzzimmer.maonamassa.model.Marca;

@Mapper(componentModel = "spring")
public interface MarcaMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MarcaDTO marcaToMarcaDTO (Marca marca);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Marca dtoToMarca(MarcaDTO marcaDTO);

    @Mapping(target = "id", ignore = true)
    void updateMarcaFromDTO(MarcaDTO dto, @MappingTarget Marca marca);

}
