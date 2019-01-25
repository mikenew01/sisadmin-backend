package io.mk.sisadmin.model.mapper;

import io.mk.sisadmin.model.dto.PerfilDTO;
import io.mk.sisadmin.model.entity.Perfil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PerfilMapper extends BaseMapper<Perfil, PerfilDTO> {

    @Override
    PerfilDTO toDto(Perfil entity);

    @Override
    List<PerfilDTO> toDto(List<Perfil> entities);

    @Override
    Perfil toEntity(PerfilDTO dto);

    @Override
    List<PerfilDTO> toDto(Iterable<Perfil> entities);

    @Override
    List<Perfil> toEntity(List<PerfilDTO> dtos);

    @InheritInverseConfiguration(name = "toDto")
    void fromDto(PerfilDTO perfilDTO, @MappingTarget Perfil entity);
}
