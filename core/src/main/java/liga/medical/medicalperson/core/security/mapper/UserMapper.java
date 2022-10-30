package liga.medical.medicalperson.core.security.mapper;

import liga.medical.medicalperson.core.security.dto.UserDto;
import liga.medical.medicalperson.core.security.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> user);

    List<User> toEntityList(List<UserDto> userDto);
}
