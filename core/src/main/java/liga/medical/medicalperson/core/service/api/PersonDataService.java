package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.entity.PersonData;

public interface PersonDataService {
    PersonData saveOrUpdatePersonData(PersonData personData);

    PersonData findById(Long id);
}
