package liga.medical.medicalperson.core.service.api;

import liga.medical.medicalperson.core.model.pojo.PersonData;

import java.util.List;

public interface PersonDataService {
    int postPersonData(PersonData personData);

    PersonData getPersonDataById(int id);

    List<PersonData> getAllPersonData();

    void deletePersonData(int id);
}
