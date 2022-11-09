package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> { }
