package liga.medical.medicalperson.core.security.repository;

import liga.medical.medicalperson.core.security.entity.AuthLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthLogRepository extends JpaRepository<AuthLog, Long> { }
