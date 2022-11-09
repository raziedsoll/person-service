package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Long> { }
