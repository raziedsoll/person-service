package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<PersonData, Long> { }
