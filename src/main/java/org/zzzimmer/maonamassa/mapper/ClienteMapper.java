package org.zzzimmer.maonamassa.mapper;

import jakarta.validation.Valid;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.zzzimmer.maonamassa.dto.ClienteDTO;
import org.zzzimmer.maonamassa.dto.ModeloDTO;
import org.zzzimmer.maonamassa.dto.ResponseClienteDTO;
import org.zzzimmer.maonamassa.model.Cliente;
import org.zzzimmer.maonamassa.model.Modelo;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    Cliente dtoToCliente(@Valid ClienteDTO clienteDTO);

    ResponseClienteDTO clienteToResponseClienteDto (Cliente cliente);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCliente (ClienteDTO clienteDTO, @MappingTarget Cliente cliente);
}
