package liga.medical.medicalperson.core.dao.api;

import liga.medical.medicalperson.core.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { }
