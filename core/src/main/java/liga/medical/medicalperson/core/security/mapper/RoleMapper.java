package liga.medical.medicalperson.core.security.mapper;

import liga.medical.medicalperson.core.security.dto.RoleDto;
import liga.medical.medicalperson.core.security.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);

    List<RoleDto> toDtoList(List<Role> role);

    List<Role> toEntityList(List<RoleDto> roleDto);
}
