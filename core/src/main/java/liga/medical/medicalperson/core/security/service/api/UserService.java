package liga.medical.medicalperson.core.security.service.api;

import liga.medical.medicalperson.core.security.dto.UserDto;
import liga.medical.medicalperson.core.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

    User findByUsername(String username);

    List<UserDto> getUsers();

    boolean deleteUser(Long userId);
}
