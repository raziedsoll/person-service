package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> { }
