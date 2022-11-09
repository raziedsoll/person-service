package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Signals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalsRepository extends JpaRepository<Signals, Long> {
}
