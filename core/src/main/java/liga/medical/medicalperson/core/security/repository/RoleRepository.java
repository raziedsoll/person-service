package liga.medical.medicalperson.core.security.repository;

import liga.medical.medicalperson.core.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
